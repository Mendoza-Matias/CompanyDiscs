package com.record.company.com.config.security;

import com.record.company.com.domain.dto.user.UserLoginDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class HashPassword {

    public static UsernamePasswordAuthenticationToken passwordHash(UserLoginDto user){
        return new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
    }
}
