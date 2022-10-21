package com.gcu.preach.Business;

import com.gcu.preach.entity.UserModel;

public interface UserBusinessServiceInterface {

	boolean authenticateUser(String username, String password);

	boolean registerUser(UserModel userModel);

	UserModel getUserByUsername(String username);

	boolean update(UserModel userModel);

}
