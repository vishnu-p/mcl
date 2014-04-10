package com.mcl.frontend.service;

import com.mcl.frontend.service.bean.UserAccountBean;

public interface AuthenticationService {
	
	void registerPreAuthenticatedAuthenticationToken(
			final UserAccountBean userAccountBean);

}
