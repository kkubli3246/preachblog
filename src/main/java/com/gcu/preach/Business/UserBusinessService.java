package com.gcu.preach.Business;


import com.gcu.preach.model.UserModel;

public class UserBusinessService implements UserBusinessServiceInterface {

    public boolean authenticateUser(String username, String password) {
        return username.equals("admin") && password.equals("SuperSecurePassword123");
    }

    public UserModel registerUser(UserModel user) {
        return new UserModel(user.getUserName(), user.getUserPassword(), user.getUserEmail(), user.getUserFirstName(),
                user.getUserLastName(), user.getUserPhoneNumber(), user.getUserAddress1(), user.getUserAddress2(),
                user.getUserCity(), user.getUserState(), user.getUserZip());
    }


}

