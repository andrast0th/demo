package com.example.demo.service;

import com.example.demo.api.model.RegisterUserRequestModel;
import com.example.demo.api.model.RoleConstants;
import com.example.demo.api.model.UserResponseModel;
import com.example.demo.mapper.UserMapper;
import com.example.demo.peristance.entity.RoleEntity;
import com.example.demo.peristance.entity.UserEntity;
import com.example.demo.peristance.repository.RoleRepository;
import com.example.demo.peristance.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponseModel> getAllUsers() {
        return this.userRepository
                .findAll()
                .stream()
                .map(this.userMapper::toUserModel)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseModel getByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .map(this.userMapper::toUserModel)
                .orElseThrow();
    }

    @Override
    public UserResponseModel registerUser(RegisterUserRequestModel model) {
        if(this.userRepository.findByUsername(model.getUsername()).isPresent()) {
            throw new RuntimeException("Username taken.");
        }

        UserEntity userEntity = userMapper.toUserEntity(model);

        userEntity.setPassword(passwordEncoder.encode(model.getPassword()));

        // default role for new users
        RoleEntity role = roleRepository
                .findById(RoleConstants.USER)
                .orElseThrow();
        userEntity.setRoles(new HashSet<>(Collections.singleton(role)));

        UserEntity savedUser = userRepository.save(userEntity);

        return userMapper.toUserModel(savedUser);
    }

}
