/**
 * 
 */
package com.mcl.backend.core.persistence.model.client;

/**
 * @author vishnu-p
 *
 */
public class UserCredentials {
	
	private String username;
	private String emailId;
	private String password;
	private String securityQuestion;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
}
