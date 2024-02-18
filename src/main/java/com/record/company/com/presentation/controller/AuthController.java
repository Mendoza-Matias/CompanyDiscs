package com.record.company.com.presentation.controller;

import com.record.company.com.bussines.IUserServices;
import com.record.company.com.bussines.security.AuthServices;
import com.record.company.com.domain.dto.security.AuthenticationRequest;
import com.record.company.com.domain.dto.security.AuthenticationResponse;
import com.record.company.com.domain.dto.user.UserCreateDto;
import com.record.company.com.domain.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthServices authServices;

    @Autowired
    private IUserServices userServices;

    @PreAuthorize("permitAll")
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse>login (@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(authServices.login(authenticationRequest));
    }

    @PreAuthorize("permitAll")
    @PostMapping("/register")
    public ResponseEntity <UserDto> register (@RequestBody UserCreateDto user){
        return ResponseEntity.created(URI.create("/api/v1/recordCompany")).body(userServices.register(user));
    }
}
