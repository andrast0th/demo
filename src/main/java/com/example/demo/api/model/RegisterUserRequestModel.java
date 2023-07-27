package com.example.demo.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestModel {
    private String username;
    private String email;
    private String password;
}
