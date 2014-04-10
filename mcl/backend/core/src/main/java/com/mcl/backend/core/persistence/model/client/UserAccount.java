package com.mcl.backend.core.persistence.model.client;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.mcl.backend.core.persistence.model.BaseObject;

/**
 * UserAccount Class for MCL User
 * 
 * @author vishnu-p
 * 
 */
public class UserAccount extends BaseObject {

	
	private static final long serialVersionUID = 649840951596814698L;

	private Long userId;
	private String firstName;
	private String lastName;
	private String role;	
	private UserCredentials userCredentials;
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

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return EqualsBuilder.reflectionEquals(o, this);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return HashCodeBuilder.reflectionHashCode(this);
	}

}
