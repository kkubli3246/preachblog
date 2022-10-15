package com.gcu.preach.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {

	// Private class variables
	@NotNull(message = "User name field cannot be empty!")
	@Size(min = 1, max = 32, message = "User name must be between 1 and 32 characters long!")
	private String userName;

	@NotNull(message = "Password field cannot be empty!")
	@Size(min = 1, max = 10000, message = "Password must be between 1 and 32 characters long!")
	private String password;

	// Getters and Setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
