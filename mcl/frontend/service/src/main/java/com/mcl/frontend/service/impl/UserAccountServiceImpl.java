/**
 * 
 */
package com.mcl.frontend.service.impl;

import java.util.List;

import org.perf4j.aop.Profiled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcl.backend.core.persistence.model.client.UserAccount;
import com.mcl.backend.core.service.UserAccountManager;
import com.mcl.frontend.service.UserAccountService;
import com.mcl.frontend.service.bean.UserAccountBean;
import com.mcl.frontend.service.common.exception.MCLServiceException;
import com.mcl.frontend.service.helper.UserAccountHelper;

/**
 * @author vishnu-p
 *
 */
@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService {
	
	static final Logger LOGGER = LoggerFactory
			.getLogger(UserAccountServiceImpl.class);
	
	private static final int MAX_NUMBER_OF_ATTEMPTS_REMAINING = 3;

	private static final String RM_DMU_USER = "MANAGER";
	
	private static final String CLIENT = "CLIENT";
		
	private UserAccountManager userAccountManager;
	
	@Autowired
	public UserAccountServiceImpl(UserAccountManager userAccountManager) {
		this.userAccountManager = userAccountManager;
	}


	@Override
	@Profiled(tag = "SVC_searchUser")
	public List<UserAccountBean> searchUser(Long clientId, Long userId,
			String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Profiled(tag = "SVC_get")
	public UserAccountBean get(Long id) {
		UserAccountBean userAccountBean = new UserAccountBean();
		try {
			UserAccount userAccount = userAccountManager.get(id.longValue());
			userAccountBean = UserAccountHelper.buildUserAccountBean(userAccount);					
			} catch (Exception e) {
			final String error = String
					.format("Unexpected error while getting user using userId");
			LOGGER.error(error, e);
			throw new MCLServiceException(e.getCause(), e.getMessage(), e);
		}
		return userAccountBean;
	}

	@Override
	@Profiled(tag = "SVC_getAllUserAccounts")
	public List<UserAccountBean> getAllUserAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Profiled(tag = "SVC_update")
	public boolean update(UserAccountBean userAccountBean) {
		try {
			UserAccount userAccount = UserAccountHelper.buildUserAccount(userAccountBean);
			return userAccountManager.update(userAccount);
		} catch (Exception e) {
			final String error = String
					.format("Unexpected error while updating the User Account");
			LOGGER.error(error, e);
			throw new MCLServiceException(e.getCause(), e.getMessage(), e);
		}
	}

	@Override
	@Profiled(tag = "SVC_delete")
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Profiled(tag = "SVC_getPassword")
	public String getPassword(Long id) {
		String password = null;
		try {
			password = userAccountManager.getPassword(id);
		} catch (Exception e) {
			final String error = String
					.format("Unexpected error while retrieving the password for user with id %s", id);
			LOGGER.error(error, e);
			throw new MCLServiceException(e.getCause(), e.getMessage(), e);
		}
		return password;
	}

	@Override
	@Profiled(tag = "SVC_validateLogin")
	public boolean validateLogin(String username, String password) {
		boolean isValidLogin = false;
		try {
			isValidLogin = userAccountManager.validateLogin(username, password);
		} catch (Exception e) {
			final String error = String
					.format("Unexpected error while getting user using username and password");
			LOGGER.error(error, e);
			throw new MCLServiceException(e.getCause(), e.getMessage(), e);
		}
		return isValidLogin;
	}

	@Override
	@Profiled(tag = "SVC_decrementNumberOfAttempts")
	public int decrementNumberOfAttempts(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Profiled(tag = "SVC_resetNumberOfAttempts")
	public void resetNumberOfAttempts(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Profiled(tag = "SVC_lockUserAccount")
	public void lockUserAccount(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Profiled(tag = "SVC_unlockUserAccount")
	public void unlockUserAccount(Long id) {
		try {
			userAccountManager.unlockUserAccount(id);
		} catch (Exception e) {
			final String error = String
					.format("Unexpected error while unlocking the user");
			LOGGER.error(error, e);
			throw new MCLServiceException(e.getCause(), e.getMessage(), e);
		}
	}

	@Override
	@Profiled(tag = "SVC_changePassword")
	public boolean changePassword(Long id, String password) {
		boolean isPasswordChanged = false;
		try {
			isPasswordChanged = userAccountManager.changePassword(id,
					password);
		} catch (Exception e) {
			final String error = String
					.format("Unexpected error while Changing Password");
			LOGGER.error(error, e);
			throw new MCLServiceException(e.getCause(), e.getMessage(), e);
		}
		return isPasswordChanged;
	}

	@Override
	@Profiled(tag = "SVC_getEncryptedPassword")
	public String getEncryptedPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Profiled(tag = "SVC_acceptTermsAndConditions")
	public void acceptTermsAndConditions(Long id) {
		try {
			userAccountManager.acceptTermsAndConditions(id);
		} catch (Exception e) {
			final String error = String
					.format("User didnt checked in Terms and conditions box");
			LOGGER.error(error, e);	
			throw new MCLServiceException(e.getCause(), e.getMessage(), e);
		}
		
	}

	@Override
	@Profiled(tag = "SVC_getUserAccountByUsername")
	public UserAccountBean getUserAccountByUsername(String username) {
		UserAccount userAccount = userAccountManager.getUserAccountByUsername(username);				
		return UserAccountHelper.buildUserAccountBean(userAccount);
	}

	@Override
	@Profiled(tag = "SVC_isUserExists")
	public boolean isUserExists(String username) {
		return userAccountManager.isUserExists(username);
	}

	@Override
	@Profiled(tag = "SVC_update")
	public boolean update(Long id, String username, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
