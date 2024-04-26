package com.companyDiscs.presentation.controller;

import com.companyDiscs.bussines.services.IUserService;
import com.companyDiscs.domain.dto.user.CreateUserDto;
import com.companyDiscs.domain.dto.user.UserDto;
import com.companyDiscs.domain.entity.User;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PermitAll
    @GetMapping
    ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @PermitAll
    @GetMapping("{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }
    @PermitAll
    @PostMapping("create")
    ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(createUserDto));
    }

    @PermitAll
    @PutMapping("password/{id}")
    ResponseEntity<UserDto> modifyPassword(@PathVariable(name = "id") Long id , @RequestBody String password){
        return ResponseEntity.status(HttpStatus.OK).body(userService.modifyPassword(id,password));
    }
}
