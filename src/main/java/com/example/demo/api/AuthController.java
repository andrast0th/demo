package com.example.demo.api;

import com.example.demo.api.model.LoginRequestModel;
import com.example.demo.api.model.LoginResponseModel;
import com.example.demo.api.model.RegisterUserRequestModel;
import com.example.demo.api.model.UserResponseModel;
import com.example.demo.security.AppUserPrincipal;
import com.example.demo.security.AuthServiceImpl;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthServiceImpl authService;
    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity<LoginResponseModel> login(@RequestBody LoginRequestModel request) {
        return ResponseEntity
                .ok()
                .body(authService.doLogin(request));
    }

    @PostMapping("register")
    public ResponseEntity<UserResponseModel> register(@RequestBody RegisterUserRequestModel request) {
        return ResponseEntity
                .ok()
                .body(this.userService.registerUser(request));
    }

    @GetMapping("info")
    public ResponseEntity<UserResponseModel> currentUserInfo(@Parameter(hidden = true) @AuthenticationPrincipal AppUserPrincipal principal) {
        return ResponseEntity
                .ok()
                .body(userService.getByUsername(principal.getUsername()));
    }

}