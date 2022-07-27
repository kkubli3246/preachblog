package com.gcu.preach.dao;

import com.gcu.preach.entity.UserModel;

import java.util.List;


public interface UserRepository {

    UserModel getUserByUsername(String username);
    boolean create(UserModel userModel);
    UserModel update(UserModel userModel);
    String delete(UserModel userModel);
    List<UserModel> getAllUsers();

}
