package com.gcu.preach.Business;



import com.gcu.preach.dao.UserRepository;
import com.gcu.preach.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import static com.gcu.preach.controller.LoginUserController.userName;

public class UserBusinessService implements UserBusinessServiceInterface {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticateUser(String username, String password) {
        UserModel user = userRepository.getUserByUsername(username);
        if (user != null) {
            return user.getUserPassword().equals(password);
        }
        return false;
    }

    public boolean registerUser(UserModel userModel) {
        userRepository.create(userModel);
            return true;
    }

    public UserModel getUserByUsername(String username) {
        return userRepository.getUserByUsername(userName);
    }

    @Override
    public boolean update(UserModel userModel) {
        return userRepository.update(userModel);
    }

}

