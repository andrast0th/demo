package com.example.demo.service;


import com.example.demo.api.model.UserResponseModel;

import java.util.List;

public interface UserService {

    List<UserResponseModel> getAllUsers();
}
