package com.mcl.frontend.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import com.mcl.frontend.service.AuthenticationService;
import com.mcl.frontend.service.bean.UserAccountBean;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Override
	public void registerPreAuthenticatedAuthenticationToken(UserAccountBean userAccountBean) {
		String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
		userAccountBean.setSessionId(sessionId);
		final PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(
				userAccountBean, null);
		authentication.setAuthenticated(true);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

	public void registerPreAuthenticatedUnauthenticationToken() {
		UserAccountBean userAccount = null;
		Object auth = SecurityContextHolder.getContext().getAuthentication();
		if (null == auth) {
			final PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(
					userAccount, null);
			authentication.setAuthenticated(false);

			SecurityContextHolder.getContext()
					.setAuthentication(authentication);
		}

	}	   
}
