package com.example.demo.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseModel {
    private String username;
    private String email;
    private List<String> roles;
}
