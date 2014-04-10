/**
 * 
 */
package com.mcl.backend.core.service.impl;

import java.util.List;

import org.perf4j.aop.Profiled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcl.backend.core.persistence.dao.UserAccountDao;
import com.mcl.backend.core.persistence.model.client.UserAccount;
import com.mcl.backend.core.service.UserAccountManager;

/**
 * @author vishnu-p
 *
 */
@Service("userAccountManager")
@Transactional
public class UserAccountManagerImpl implements UserAccountManager {
	
	static final Logger LOGGER = LoggerFactory
			.getLogger(UserAccountManagerImpl.class);

	private final UserAccountDao userAccountDao;

	private static final int PIN_LENGTH = 6;
	
	private static final int MAX_NUMBER_OF_ATTEMPTS_REMAINING = 3;	

	@Autowired
	public UserAccountManagerImpl(final UserAccountDao userAccountDao) {
		this.userAccountDao = userAccountDao;	
	}

	@Override
	@Profiled(tag = "SVC_searchUser")
	public List<UserAccount> searchUser(Long clientId, Long userId,
			String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Profiled(tag = "SVC_get")
	public UserAccount get(Long id) {
		UserAccount userAccount = null;
		try {
			userAccount = userAccountDao.get(id);
			final String password = userAccount.getUserCredentials().getPassword();	
		
		} catch (RuntimeException ex) {
			LOGGER.error("Runtime Exception: " + ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Internal Server Exception: " + ex.getMessage());
		}
		return userAccount;
	}

	@Override
	@Profiled(tag = "SVC_update")
	public boolean update(UserAccount userAccount) {
		boolean isUpdated = false;
		try {
			isUpdated = userAccountDao.update(userAccount);
		} catch (RuntimeException ex) {
			LOGGER.error("Runtime Exception: " + ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Internal Server Exception: " + ex.getMessage());
		}
		return isUpdated;
	}

	@Override
	@Profiled(tag = "SVC_delete")
	public boolean delete(Long id) {
		boolean isDeleted = false;
		UserAccount userAccount = get(id);
		userAccount.setDeletedAccount(true);				
		try {
			isDeleted = update(userAccount);
		} catch (RuntimeException ex) {
			LOGGER.error("Runtime Exception: " + ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Internal Server Exception: " + ex.getMessage());
		}
		return isDeleted;
	}

	@Override
	@Profiled(tag = "SVC_getPassword")
	public String getPassword(Long id) {
		String decryptedPassword = null;
		try {
			UserAccount user = userAccountDao.get(id);
			decryptedPassword = user.getUserCredentials().getPassword();
						
		} catch (RuntimeException ex) {
			LOGGER.error("Runtime Exception: " + ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Internal Server Exception: " + ex.getMessage());
		}
		return decryptedPassword;
	}

	@Override
	@Profiled(tag = "SVC_validateLogin")
	public boolean validateLogin(String username, String password) {
		boolean validateLogin = false;
		try {
			UserAccount user = getUserAccountByUsername(username);
			final String decryptedPassword = user.getUserCredentials().getPassword().trim();
			
			if(decryptedPassword.equalsIgnoreCase(password.trim())) {
				validateLogin = true;
			}
		} catch (RuntimeException ex) {
			LOGGER.error("Runtime Exception: " + ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Internal Server Exception: " + ex.getMessage());
		}
		return validateLogin;
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
		try {
			UserAccount userAccount = get(id);
			userAccount.setLockedAccount(true);			
			update(userAccount);
		} catch (RuntimeException ex) {
			LOGGER.error("Runtime Exception: " + ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Internal Server Exception: " + ex.getMessage());
		}		
	}

	@Override
	@Profiled(tag = "SVC_unlockUserAccount")
	public void unlockUserAccount(Long id) {
		try {
			UserAccount userAccount = get(id);
			userAccount.setLockedAccount(false);
			
			//userAccount.setNumberOfAttemptsRemaining(MAX_NUMBER_OF_ATTEMPTS_REMAINING);
			
			update(userAccount);
		} catch (RuntimeException ex) {
			LOGGER.error("Runtime Exception: " + ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Internal Server Exception: " + ex.getMessage());
		}
	}

	@Override
	@Profiled(tag = "SVC_changePassword")
	public boolean changePassword(Long id, String password) {
		boolean changePassword = false;
		try {
			UserAccount userAccount = get(id);			
			userAccount.getUserCredentials().setPassword(password.trim());
			
			changePassword = (update(userAccount));
		} catch (RuntimeException ex) {
			LOGGER.error("Runtime Exception: " + ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Internal Server Exception: " + ex.getMessage());
		}
		return changePassword;
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
			UserAccount userAccount = get(id);
			userAccount.setTermsAccepted(true);			
			update(userAccount);
		} catch (RuntimeException ex) {
			LOGGER.error("Runtime Exception: " + ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Internal Server Exception: " + ex.getMessage());
		}
		
	}

	@Override
	@Profiled(tag = "SVC_getUserAccountByUsername")
	public UserAccount getUserAccountByUsername(String username) {
		UserAccount userAccount = null;
		try {
			userAccount = userAccountDao.getUserAccountByUsername(username
					.trim());		
			
		} catch (RuntimeException ex) {
			LOGGER.error("Runtime Exception: " + ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Internal Server Exception: " + ex.getMessage());
		}
		return userAccount;
	}

	@Override
	@Profiled(tag = "SVC_isUserExists")
	public boolean isUserExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Profiled(tag = "SVC_update")
	public boolean update(Long id, String username, String newPassword) {
		boolean isUpdated = false;
		try {
			UserAccount userAccount = get(id);
			userAccount.getUserCredentials().setUsername(username);			
			userAccount.getUserCredentials().setPassword(newPassword.trim());			

			isUpdated = update(userAccount);
		} catch (RuntimeException ex) {
			LOGGER.error("Runtime Exception: " + ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Internal Server Exception: " + ex.getMessage());
		}
		return isUpdated;
	}

	@Override
	@Profiled(tag = "SVC_getAllUserAccounts")
	public List<UserAccount> getAllUserAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

}
