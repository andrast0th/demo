package com.example.demo.service;

import com.example.demo.api.model.UserResponseModel;
import com.example.demo.mapper.UserMapper;
import com.example.demo.peristance.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseModel> getAllUsers() {
        return this.userRepository
                .findAll()
                .stream()
                .map(this.userMapper::toUserModel)
                .collect(Collectors.toList());
    }

}
