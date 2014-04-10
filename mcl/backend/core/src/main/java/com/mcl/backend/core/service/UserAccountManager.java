package com.mcl.backend.core.service;

import java.util.List;
import com.mcl.backend.core.persistence.model.client.UserAccount;

public interface UserAccountManager {

	List<UserAccount> searchUser(Long clientId, Long userId, String firstName, String lastName);

	UserAccount get(Long id);
	
	List<UserAccount> getAllUserAccounts();

	boolean update(UserAccount userAccount);

	boolean delete(Long id);	

	String getPassword(Long id);

	boolean validateLogin(String username, String password);
	
	int decrementNumberOfAttempts(Long id);
	
	void resetNumberOfAttempts(Long id);
	
	void lockUserAccount(Long id);

	void unlockUserAccount(Long id);

	boolean changePassword(Long id, String password);
	
	String getEncryptedPassword(final String password);

	void acceptTermsAndConditions(Long id);
	
	UserAccount getUserAccountByUsername(String username);
	
	boolean isUserExists(String username);
	
	boolean update(Long id, String username, String newPassword);
	
}
