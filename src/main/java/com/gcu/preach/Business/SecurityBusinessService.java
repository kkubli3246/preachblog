package com.gcu.preach.Business;

import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService {

    public boolean authenticateUser(String username, String password) {
        if (username.equals("admin") && password.equals("SuperSecurePassword123")) {
            return true;
        } else {
            return false;
        }
    }
}
