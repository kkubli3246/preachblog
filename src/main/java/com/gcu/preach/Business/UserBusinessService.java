package com.gcu.preach.Business;



import com.gcu.preach.dao.UserRepository;
import com.gcu.preach.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

public class UserBusinessService implements UserBusinessServiceInterface {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticateUser(String username, String password) {
        UserModel user = userRepository.getUserByUsername(username);
        if (user != null) {
            if (user.getUserPassword().equals(password)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public boolean registerUser(UserModel userModel) {

    return true;
    }
}

