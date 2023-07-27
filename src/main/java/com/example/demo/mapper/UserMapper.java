package com.example.demo.mapper;

import com.example.demo.api.model.UserResponseModel;
import com.example.demo.peristance.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserMapper {
    UserResponseModel toUserModel(UserEntity user);
}