package com.companyDiscs.presentation.controller;

import com.companyDiscs.bussines.services.security.AuthenticationService;
import com.companyDiscs.domain.dto.auth.AuthenticationRequest;
import com.companyDiscs.domain.dto.auth.AuthenticationResponse;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public String hello(){
        return "hello";
    }

    @PermitAll
    @PostMapping("/login")
    public AuthenticationResponse auth (@RequestBody AuthenticationRequest authenticationRequest){
        return authenticationService.auth(authenticationRequest);
    }
}
