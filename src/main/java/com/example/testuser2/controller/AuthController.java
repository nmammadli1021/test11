package com.example.testuser2.controller;

import com.example.testuser2.Service.auth.AuthService;
import com.example.testuser2.Service.service.LoginAttemptService;
import com.example.testuser2.dao.entity.UserEntity;
import com.example.testuser2.dto.AuthRequestDto;
import com.example.testuser2.dto.AuthenticationDto;
import com.example.testuser2.dto.UserRegisterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final LoginAttemptService loginAttemptService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationDto> register(
            @RequestBody UserRegisterRequestDto requestDto
    ) {
        return ResponseEntity.ok(authService.register(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationDto> login(
            @RequestBody AuthRequestDto authRequestDto) {

        String email = authRequestDto.getEmail();

        if (loginAttemptService.isAccountLocked(email)) {
            return ResponseEntity.status(HttpStatus.LOCKED)
                    .body(new AuthenticationDto("Your account has been blocked. Please try again later."));
        }


        if (!loginAttemptService.loginFailed(email)) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthenticationDto("Incorrect username or password."));

        } else {
            return ResponseEntity.ok(authService.authenticate(authRequestDto));
        }
    }
}