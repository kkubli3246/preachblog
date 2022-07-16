package com.gcu.preach.Business;


public interface UserBusinessServiceInterface {

     boolean authenticateUser(String username, String password);
     boolean registerUser(String username, String password);
}
