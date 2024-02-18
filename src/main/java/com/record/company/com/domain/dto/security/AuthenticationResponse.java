package com.record.company.com.domain.dto.security;

import com.record.company.com.domain.dto.user.UserDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthenticationResponse {
    private UserDto user;
    private String tokenType = "Bearer";
    private String token;
}
