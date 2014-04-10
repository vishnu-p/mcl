package com.mcl.frontend.service.helper;

import com.mcl.backend.core.persistence.model.client.UserAccount;
import com.mcl.backend.core.persistence.model.client.UserCredentials;
import com.mcl.frontend.service.bean.UserAccountBean;
import com.mcl.frontend.service.bean.UserCredentialsBean;

public final class UserAccountHelper {

	private UserAccountHelper() {
		// hiding constructor
	}

	public static UserAccount buildUserAccount(
			final UserAccountBean userAccountBean) {
		return convertFormBeanToDomainObject(userAccountBean);
	}

	public static UserAccountBean buildUserAccountBean(
			final UserAccount userAccount) {
		return convertDomainObjectToFormBean(userAccount);
	}

	private static UserAccount convertFormBeanToDomainObject(
			final UserAccountBean userAccountBean) {
		final UserAccount userAccount = new UserAccount();
		if (userAccountBean != null) {

			userAccount.setFirstName(userAccountBean.getFirstName());
			userAccount.setLastName(userAccountBean.getLastName());

			UserCredentials userCredentials = new UserCredentials();
			userCredentials.setUsername(userAccountBean
					.getUserCredentialsBean().getUsername());
			userCredentials.setPassword(userAccountBean
					.getUserCredentialsBean().getPassword());

			userCredentials.setSecurityQuestion(userAccountBean
					.getUserCredentialsBean().getSecurityQuestion());
			userAccount.setUserCredentials(userCredentials);
			userAccount.setLockedAccount(userAccountBean.isLockedAccount());

			userAccount.setDeletedAccount(userAccountBean.isDeletedAccount());
			userAccount.setTermsAccepted(userAccountBean.isTermsAccepted());

			userAccount.setEmailConfirmed(userAccountBean.isEmailConfirmed());

			userAccount.setRole(userAccountBean.getRole());
		}
		return userAccount;
	}

	private static UserAccountBean convertDomainObjectToFormBean(
			final UserAccount userAccount) {
		final UserAccountBean userAccountBean = new UserAccountBean();
		if (userAccount != null) {
			userAccountBean.setUserId(userAccount.getUserId());
				
			userAccountBean.setRole(userAccount.getRole());
			
			userAccountBean.setFirstName(userAccount.getFirstName());
			
			userAccountBean.setLastName(userAccount.getLastName());
			
			userAccountBean.setLockedAccount(userAccount.isLockedAccount());
		
		
			userAccountBean.setDeletedAccount(userAccount.isDeletedAccount());
			userAccountBean.setTermsAccepted(userAccount.isTermsAccepted());
			
			userAccountBean.setEmailConfirmed(userAccount.isEmailConfirmed());
			

			if (userAccount.getUserCredentials() != null) {
				UserCredentials userCredentials = userAccount
						.getUserCredentials();
				UserCredentialsBean userCredentialsBean = new UserCredentialsBean();

				userCredentialsBean.setUsername(userCredentials.getUsername());
				userCredentialsBean.setPassword(userCredentials.getPassword());
			
				userCredentialsBean.setSecurityQuestion(userCredentials
						.getSecurityQuestion());

				userAccountBean.setUserCredentialsBean(userCredentialsBean);
			}

		}
		return userAccountBean;
	}

}
