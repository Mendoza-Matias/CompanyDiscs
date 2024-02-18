package com.record.company.com.bussines.security;

import com.record.company.com.domain.dto.security.AuthenticationRequest;
import com.record.company.com.domain.dto.security.AuthenticationResponse;

import com.record.company.com.domain.dto.user.UserDto;
import com.record.company.com.domain.entity.User;
import com.record.company.com.exception.UserException;
import com.record.company.com.persistence.repository.IUserRepository;
import com.record.company.com.config.filter.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class AuthServices {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    public AuthenticationResponse login (AuthenticationRequest authenticationRequest){

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getEmail(),authenticationRequest.getPassword()
        );
        authenticationManager.authenticate(usernamePasswordAuthenticationToken).getPrincipal();

        User userEmail = userRepository.findByEmail(authenticationRequest.getEmail()).get();

        if( userEmail == null) {
            throw new UserException("User email not found");
        }

        String jwt = jwtService.generateToken(userEmail,generateExtraClaims(userEmail));

        return AuthenticationResponse.builder()
                .user(modelMapper.map(userEmail, UserDto.class))
                .tokenType("Bearer")
                .token(jwt)
                .build();

    }

    private Map <String,Object> generateExtraClaims(User user){
        Map<String,Object> extraClaims = new HashMap<>();
        extraClaims.put("name",user.getName());
        extraClaims.put("role",user.getRol().name());
        extraClaims.put("authorities",user.getAuthorities());
        return extraClaims;
    }
}
