package com.example.demo.security;

import com.example.demo.api.model.LoginRequestModel;
import com.example.demo.api.model.LoginResponseModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authManager;
    private final JwtTokenUtil jwtUtil;

    @Transactional
    @Override
    public LoginResponseModel doLogin(LoginRequestModel authRequestModel) {
        final Authentication authentication;

        try {
            authentication =
                    authManager.authenticate(
                            new UsernamePasswordAuthenticationToken(authRequestModel.getUsername(), authRequestModel.getPassword())
                    );
        } catch (BadCredentialsException | LockedException ex) {
            log.error(ex.getMessage());
            throw ex;
        }

        final var user = (AppUserPrincipal) authentication.getPrincipal();
        final var jwt = jwtUtil.generateAccessToken(user);
        return new LoginResponseModel(jwt);
    }

    @Transactional
    @Override
    public void doLogout(String jwtToken) {
        // TODO hehe
    }
}
