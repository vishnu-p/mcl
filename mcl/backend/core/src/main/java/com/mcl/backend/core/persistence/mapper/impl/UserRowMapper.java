package com.mcl.backend.core.persistence.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.mcl.backend.core.persistence.mapper.BaseRowMapper;
import com.mcl.backend.core.persistence.model.client.UserAccount;
import com.mcl.backend.core.persistence.model.client.UserCredentials;

@Component("userRowMapper")
public class UserRowMapper extends BaseRowMapper<UserAccount> {
	
	@Override
	public UserAccount mapRowImpl(final ResultSet rs, final int rowNum) throws SQLException {

		UserAccount userAccount = new UserAccount();
		UserCredentials userCredentials =new  UserCredentials();
		
		userAccount.setUserId(rs.getLong("ID"));		

		userAccount.setFirstName(rs.getString("FIRST_NAME"));
		userAccount.setLastName(rs.getString("LAST_NAME"));		
		
		userAccount.setRole(rs.getString("ROLE"));
				
		if ("Y".equalsIgnoreCase(rs.getString("LOCKED_YN"))) {
			userAccount.setLockedAccount(true);
		} else {
			userAccount.setLockedAccount(false);
		}

		if ("Y".equalsIgnoreCase(rs.getString("DELETE_USER_YN"))) {
			userAccount.setDeletedAccount(true);
		} else {
			userAccount.setDeletedAccount(false);
		}

		if ("Y".equalsIgnoreCase(rs.getString("TERMS_ACCEPTED_YN"))) {
			userAccount.setTermsAccepted(true);
		} else {
			userAccount.setTermsAccepted(false);
		}

		if ("Y".equalsIgnoreCase(rs.getString("EMAIL_CONFIRMED_YN"))) {
			userAccount.setEmailConfirmed(true);
		} else {
			userAccount.setEmailConfirmed(false);
		}      

		userCredentials.setPassword(rs.getString("PASSWORD"));

		userCredentials.setUsername(rs.getString("USERNAME"));	

		userAccount.setUserCredentials(userCredentials);	

		return userAccount;
		
	}
}
