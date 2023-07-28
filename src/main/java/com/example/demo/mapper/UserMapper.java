package com.example.demo.mapper;

import com.example.demo.api.model.RegisterUserRequestModel;
import com.example.demo.api.model.UserResponseModel;
import com.example.demo.peristance.entity.RoleEntity;
import com.example.demo.peristance.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel="spring")
public interface UserMapper {

    @Mapping(source="roles", target="roles")
    UserResponseModel toUserModel(UserEntity user);

    default List<String> roleEntitiesToRoleString(Set<RoleEntity> roleEntityList) {
        return roleEntityList
                .stream()
                .map(RoleEntity::getRoleName)
                .collect(Collectors.toList());
    };

    UserEntity toUserEntity(RegisterUserRequestModel user);

}