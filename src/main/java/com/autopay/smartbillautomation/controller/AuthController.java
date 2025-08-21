package com.autopay.smartbillautomation.controller;

import com.autopay.smartbillautomation.dto.AuthResponseDto;
import com.autopay.smartbillautomation.dto.LoginRequestDto;
import com.autopay.smartbillautomation.dto.RegisterRequestDto;
import com.autopay.smartbillautomation.entity.User;
import com.autopay.smartbillautomation.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequestDto registerRequest) {
        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(registerRequest.getPassword());
        authService.registerUser(newUser);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequest) {
        String token = authService.loginAndGetToken(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.ok(new AuthResponseDto(token));
    }
}
