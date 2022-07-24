package com.gcu.preach.Business;


import com.gcu.preach.model.UserModel;

public interface UserBusinessServiceInterface {

     boolean authenticateUser(String username, String password);
     UserModel registerUser(UserModel user);


}
