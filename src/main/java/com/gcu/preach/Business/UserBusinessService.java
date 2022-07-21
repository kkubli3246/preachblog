package com.gcu.preach.Business;

import org.springframework.stereotype.Service;


public class UserBusinessService implements UserBusinessServiceInterface {

    public boolean authenticateUser(String username, String password) {
        return username.equals("admin") && password.equals("SuperSecurePassword123");
    }

    public boolean registerUser(String username, String password) {
        return username.equals("admin") && password.equals("SuperSecurePassword123");
    }


}

