package com.mcl.frontend.service.bean;

import java.io.Serializable;

/**
 * UserAccount Class for MCL User
 * 
 * @author vishnu-p
 * 
 */
public class UserAccountBean implements Serializable {	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6529662054437845159L;
	private Long userId;
	private String sessionId;
	private String firstName;
	private String lastName;
	private String role;	
	private UserCredentialsBean userCredentialsBean;
	private boolean deletedAccount;
	private boolean lockedAccount;
	private boolean emailConfirmed;
	private boolean termsAccepted;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserCredentialsBean getUserCredentialsBean() {
		return userCredentialsBean;
	}
	public void setUserCredentialsBean(UserCredentialsBean userCredentialsBean) {
		this.userCredentialsBean = userCredentialsBean;
	}
	public boolean isDeletedAccount() {
		return deletedAccount;
	}
	public void setDeletedAccount(boolean deletedAccount) {
		this.deletedAccount = deletedAccount;
	}
	public boolean isLockedAccount() {
		return lockedAccount;
	}
	public void setLockedAccount(boolean lockedAccount) {
		this.lockedAccount = lockedAccount;
	}
	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}
	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}
	public boolean isTermsAccepted() {
		return termsAccepted;
	}
	public void setTermsAccepted(boolean termsAccepted) {
		this.termsAccepted = termsAccepted;
	}
	
}
