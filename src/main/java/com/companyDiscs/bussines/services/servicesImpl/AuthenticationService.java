package com.companyDiscs.bussines.services.servicesImpl;

import com.companyDiscs.domain.dto.auth.AuthenticationRequest;
import com.companyDiscs.domain.dto.auth.AuthenticationResponse;
import com.companyDiscs.domain.entity.User;
import com.companyDiscs.exception.NotFoundException;
import com.companyDiscs.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public AuthenticationResponse auth(AuthenticationRequest authenticationRequest){

        User user = userRepository.findByUserName(authenticationRequest.getName()).orElseThrow(()-> new NotFoundException("user not found"));

       return AuthenticationResponse.builder()
               .name(user.getUsername())
               .build();
    }

}
