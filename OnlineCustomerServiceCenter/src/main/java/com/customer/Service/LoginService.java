package com.customer.Service;

import javax.security.auth.login.LoginException;

import com.customer.Entity.Login;

public interface LoginService {
	
	public String loginUser(Login credential) throws LoginException;
	
	public String logoutUser (String Key) throws LoginException;

}
