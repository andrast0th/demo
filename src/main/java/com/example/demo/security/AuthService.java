package com.example.demo.security;

import com.example.demo.api.model.LoginRequestModel;
import com.example.demo.api.model.LoginResponseModel;

public interface AuthService {
    LoginResponseModel doLogin(final LoginRequestModel authRequestModel);
    void doLogout(final String jwtToken);
}
