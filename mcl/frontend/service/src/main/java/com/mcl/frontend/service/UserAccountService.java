package com.mcl.frontend.service;

import java.util.List;

import com.mcl.frontend.service.bean.UserAccountBean;

public interface UserAccountService {

	List<UserAccountBean> searchUser(Long clientId, Long userId, String firstName, String lastName);

	UserAccountBean get(Long id);
	
	List<UserAccountBean> getAllUserAccounts();

	boolean update(UserAccountBean userAccount);

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
	
	UserAccountBean getUserAccountByUsername(String username);
	
	boolean isUserExists(String username);
	
	boolean update(Long id, String username, String newPassword);
	
}
