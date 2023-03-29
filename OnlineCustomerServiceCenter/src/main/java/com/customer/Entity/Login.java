package com.customer.Entity;

import jakarta.validation.constraints.NotNull;

public class Login {

	@NotNull(message = "email cannot set as null")
	private String email;

	@NotNull(message = "password cannot set as null")
	private String password;

	
	private String User_Type;


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUser_Type() {
		return User_Type;
	}


	public void setUser_Type(String user_Type) {
		User_Type = user_Type;
	}


	public Login() {
		super();
	}


	

	public Login(@NotNull(message = "email cannot set as null") String email,
			@NotNull(message = "password cannot set as null") String password, String user_Type) {
		super();
		this.email = email;
		this.password = password;
		this.User_Type = user_Type;
	}


	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + ", User_Type=" + User_Type + "]";
	}

	

	
}
