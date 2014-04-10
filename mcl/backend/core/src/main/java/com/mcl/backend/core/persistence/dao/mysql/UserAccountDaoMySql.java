package com.mcl.backend.core.persistence.dao.mysql;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.perf4j.aop.Profiled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.mcl.backend.core.persistence.dao.UserAccountDao;
import com.mcl.backend.core.persistence.mapper.impl.UserRowMapper;
import com.mcl.backend.core.persistence.model.client.UserAccount;
import com.mcl.backend.core.persistence.resultextractor.UserAccountResultExtractor;

@Repository("userAccountDao")
public class UserAccountDaoMySql implements UserAccountDao {

	static final Logger LOGGER = LoggerFactory.getLogger(UserAccountDaoMySql.class);

	private final JdbcTemplate jdbcTemplate;

	private final UserRowMapper userRowMapper;
	
	private final UserAccountResultExtractor userAccountResultExtractor;

	private static final String GET_USER_ACCOUNT_BY_USERNAME = "SELECT * FROM USER_ACCOUNTS UA WHERE UPPER(UA.USERNAME) = UPPER(?) AND (UA.DELETE_USER_YN = 'N' OR UA.DELETE_USER_YN IS NULL)";

	private static final String GET_USER_ACCOUNT_BY_CREDENTIALS_SQL = "SELECT * FROM USER_ACCOUNTS WHERE UPPER(USERNAME) = UPPER(?) AND PASSWORD = ? AND (DELETE_USER_YN = 'N' OR DELETE_USER_YN IS NULL) AND LOCKED_YN = 'N'";

	private static final String GET_USER_ACCOUNT_BY_USERNAME_SQL = "SELECT * FROM USER_ACCOUNTS WHERE UPPER(USERNAME) = UPPER(?)";

	private static final String GET_USER_ACCOUNT_SQL = "SELECT UA.*, CL.ID AS CLIENT_ID FROM USER_ACCOUNTS UA, CLIENTS CL WHERE UA.ID = CL.UA_ID_OWNER AND UA.ID = ?";
	
	private static final String GET_ALL_PBM = "SELECT * FROM USER_ACCOUNTS WHERE VALID_YN = 'Y' AND INITIAL_PIN_PRINT_YN = 'Y' AND DATE_ACTIVATED IS NOT NULL AND PASSWORD_LETTER_SENT_YN = 'Y' AND (DELETE_USER_YN = 'N' OR DELETE_USER_YN IS NULL) AND PBM_ID IS NOT NULL AND IOS_TEAM_YN='N' ORDER BY LAST_NAME, FIRST_NAME";

	private static final String GET_CLIENTS_BY_PBM = "SELECT ID, C.VALID_YN, CLIENT_NAME FROM CLIENTS C, USER_CLIENTS UC WHERE UC.CLI_ID = C.ID AND C.VALID_YN = 'Y' AND UC.UA_ID = ? AND UC.VALID_YN = 'Y' ORDER BY CLIENT_NAME";

	private static final String INSERT_CLIENTS_BY_PBM = "INSERT INTO USER_CLIENTS (UA_ID, CLI_ID, VALID_YN) VALUES (?,?, 'Y')";
	
	private static final String UPDATE_CLIENTS_BY_PBM = "UPDATE USER_CLIENTS SET VALID_YN = ? WHERE UA_ID = ? AND CLI_ID = ?";

	private static final String GET_NEW_USER_ACCOUNTS_SQL ="SELECT UA.ID, CL.ID AS CLIENT_ID, USERNAME, TITLE, FIRST_NAME, LAST_NAME, ADDRESS_LINE_1, UR.NAME AS ROLE,DATE_OF_BIRTH, DATE_CREATED, DATE_ACTIVATED FROM USER_ACCOUNTS UA, USER_ROLES UR, CLIENTS CL WHERE UA.URE_ID = UR.ID  AND UA.ID = CL.UA_ID_OWNER";

	private static final String GET_ACTIVATED_USER_ACCOUNTS_SQL = "SELECT UA.ID, CL.ID AS CLIENT_ID, USERNAME, TITLE, FIRST_NAME, LAST_NAME, ADDRESS_LINE_1, UR.NAME AS ROLE, DATE_OF_BIRTH, DATE_CREATED, DATE_ACTIVATED FROM USER_ACCOUNTS UA, USER_ROLES UR, CLIENTS CL WHERE UA.URE_ID = UR.ID AND  UA.ID = CL.UA_ID_OWNER";

	private static final String UPDATE_SQL = "UPDATE USER_ACCOUNTS SET PBM_ID=?, TITLE=?, FIRST_NAME=?, LAST_NAME=?, ADDRESS_LINE_1=?, ADDRESS_LINE_2=?, "
			+ "ADDRESS_LINE_3=?, ADDRESS_LINE_4=?, ADDRESS_LINE_5=?, "
			+ "EMAIL_ADDRESS=?,DATE_OF_BIRTH=?,USERNAME=?,PASSWORD=?, LOCKED_YN=?,UNLOCKED_TIMESTAMP=?,UAT_CODE=?, VALID_YN=?,TERMS_ACCEPTED_YN=?,HOME_PHONE=?,WORK_PHONE=?,MOBILE_PHONE=?,"
			+ "INITIAL_PIN_PRINT_YN=?,USER_VALIDATION_1=?,POST_CODE=?, COUNTY=?, COUNTRY=?,DATE_UPDATED=?,DATE_ACTIVATED=?,CHANGE_PASSWORD_YN=?,"
			+ "INTERNAL_USER_YN=?,DELETE_USER_YN=?,ADDRESS_LINE_6=?,URE_ID=?,"
			+ "STAFF_NUMBER=?,BANKING365_YN=?,BANKING365_SENT=?,PASSWORD_LETTER_SENT_DATE=?, PASSWORD_LETTER_SENT_YN=?,PASSWORD_LETTER_TYPE=?,AUTO_PASSWORD_REMINDER_SENT=?,AUTO_PASSWORD_REMINDER_YN=?,EMAIL_CONFIRMED_YN=?,LAST_PIN_PRINT_DATE=? ,LOGIN_ATTEMPTS_REMAINING=?,PIN=? WHERE ID = ?";

	private static final String IS_USER_EXISTS_BY_USERNAME  ="SELECT UA.*, CL.ID AS CLIENT_ID FROM USER_ACCOUNTS UA, CLIENTS CL WHERE UPPER(UA.USERNAME) = UPPER(?) AND (UA.DELETE_USER_YN = 'N' OR UA.DELETE_USER_YN IS NULL) AND UA.LOCKED_YN = 'N' AND UA.VALID_YN = 'Y'AND UA.ID = CL.UA_ID_OWNER";
	
	private static final String UPDATE_CLIENTS_SQL = "UPDATE CLIENTS SET CLIENT_NAME=?, CHANGE_TIMESTAMP=SYSDATE, VALID_YN=? WHERE ID=?";
		
	private static final String GET_USER_STATUS_SQL = "SELECT UA.ID, CL.ID AS CLIENT_ID, USERNAME, TITLE, FIRST_NAME, LAST_NAME, ADDRESS_LINE_1, UR.NAME AS ROLE, DATE_OF_BIRTH, DATE_CREATED, DATE_ACTIVATED, TERMS_ACCEPTED_YN, LOCKED_YN, INITIAL_PIN_PRINT_YN FROM USER_ACCOUNTS UA, USER_ROLES UR, CLIENTS CL WHERE UA.URE_ID = UR.ID AND UR.VALID_YN = 'Y' AND UA.ID = CL.UA_ID_OWNER";
	
	private static final String GET_USER_SITE_STATISTICS_SQL = "SELECT UA.*, CL.ID AS CLIENT_ID, UL.* FROM USER_ACCOUNTS UA, USER_LOGINS UL, CLIENTS CL WHERE UA.ID = CL.UA_ID_OWNER AND UA.VALID_YN = 'Y' AND CL.ID = UL.CL_ID AND CL.VALID_YN = 'Y' AND INITIAL_PIN_PRINT_YN = 'Y'";
	
	private static final String INSERT_LOGIN_TIME_SQL = "INSERT INTO USER_LOGINS (CL_ID, SESSION_ID, LOGIN_TIME, LOGOUT_TIME) VALUES (?,?,?,?)";
	
	private static final String UPDATE_LOGOUT_TIME_SQL = "UPDATE USER_LOGINS SET LOGOUT_TIME = ? WHERE CL_ID=? AND SESSION_ID = ?";
	
	private static final String GET_ALL_USER_ROLE = "SELECT * FROM USER_ROLES WHERE VALID_YN = 'Y'";
	
	private static final String GET_USER_ACCOUNT_BY_CLIENT_ID_SQL = "SELECT UA.*, CL.ID AS CLIENT_ID FROM USER_ACCOUNTS UA, CLIENTS CL WHERE UA.ID = CL.UA_ID_OWNER AND CL.ID = ?";

	private static final String GET_CLIENTS_COUNT_FOR_PBM_SQL = "SELECT COUNT(*) AS CLIENTS_COUNT FROM CLIENTS C, USER_CLIENTS UC WHERE UC.CLI_ID = C.ID AND C.VALID_YN = 'Y' AND UC.VALID_YN = 'Y' AND UC.UA_ID = ?";
	
	@Autowired
	public UserAccountDaoMySql(
			final JdbcTemplate jdbcTemplate,
			final UserRowMapper userRowMapper,			
			final UserAccountResultExtractor userAccountResultExtractor) {

		this.jdbcTemplate = jdbcTemplate;
		this.userRowMapper = userRowMapper;
		this.userAccountResultExtractor = userAccountResultExtractor;
	}	
	
	
	@Override
	@Profiled(tag = "PER_getUser")

	public UserAccount getUserAccount(final String username, final String password) {
		return jdbcTemplate.queryForObject(
				GET_USER_ACCOUNT_BY_CREDENTIALS_SQL, new Object[] { username,
						password }, userRowMapper);
	}

	@Override
	@Profiled(tag = "PER_getUserById")
	
	public UserAccount get(final Long id) {
		UserAccount user = jdbcTemplate.queryForObject(GET_USER_ACCOUNT_SQL,
				new Long[] { id }, userRowMapper);

		return user;
	}

	@Override
	@Profiled(tag = "PER_isUserExists")
	
	public boolean isUserExists(final String username) {
		boolean isExists = false;

		UserAccount user = jdbcTemplate.query(IS_USER_EXISTS_BY_USERNAME,
				new String[] { username }, userAccountResultExtractor);
		if (user != null) {
			isExists = true;
		}

		return isExists;
	}

	@Override
	@Profiled(tag = "PER_getUserAccountByUsername")
	
	public UserAccount getUserAccountByUsername(final String username) {
		UserAccount user = jdbcTemplate.query(
				GET_USER_ACCOUNT_BY_USERNAME, new String[] { username },
				userAccountResultExtractor);

		return user;
	}
	
	@Override
	@Profiled(tag = "PER_updateUser")	
	public boolean update(final UserAccount userAccount) {
		boolean updateStatus = false;
		int result = jdbcTemplate.update(UPDATE_SQL,
				new PreparedStatementSetter() {
					@Override
					public void setValues(final PreparedStatement ps)
							throws SQLException {
						populateUpdateStatement(userAccount, ps);
					}
				});

		if (result == 1) {
			updateStatus = true;
		}

		return updateStatus;
	}
	
	private void populateUpdateStatement(final UserAccount userAccount,
			final PreparedStatement ps) throws SQLException {

		
		ps.setString(3, userAccount.getFirstName());
		ps.setString(4, userAccount.getLastName());
		
		ps.setString(12, userAccount.getUserCredentials().getUsername());
		ps.setString(13, userAccount.getUserCredentials().getPassword());
		Boolean isLockedAccount = userAccount.isLockedAccount();
		if (isLockedAccount) {
			ps.setString(14, "Y");
		} else {
			ps.setString(14, "N");
		}
		

		
		Boolean isTermsAccepted = userAccount.isTermsAccepted();
		if (isTermsAccepted) {
			ps.setString(18, "Y");
		} else {
			ps.setString(18, "N");
		}
	

		if (userAccount.isDeletedAccount()) {
			ps.setString(31, "Y");
		} else {
			ps.setString(31, "N");
		}

		
		if (userAccount.isEmailConfirmed()) {
			ps.setString(42, "Y");
		} else {
			ps.setString(42, "N");
		}
		
		ps.setLong(46, userAccount.getUserId());		
	}
	
	@Override
	public void remove(Serializable id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<UserAccount> getUserAccounts(Long userId, String firstName,
			String lastName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<UserAccount> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserAccount get(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserAccount save(UserAccount object) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
