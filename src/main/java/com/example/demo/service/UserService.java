package com.example.demo.service;


import com.example.demo.api.model.RegisterUserRequestModel;
import com.example.demo.api.model.UserResponseModel;

import java.util.List;

public interface UserService {

    List<UserResponseModel> getAllUsers();

    UserResponseModel getByUsername(String username);

    UserResponseModel registerUser(RegisterUserRequestModel model);
}
