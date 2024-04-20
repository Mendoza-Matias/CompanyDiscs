package com.companyDiscs.presentation.controller;

import com.companyDiscs.bussines.services.IUserService;
import com.companyDiscs.domain.dto.user.CreateUserDto;
import com.companyDiscs.domain.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class IUserController {
    @Autowired
    private IUserService userService;
    @GetMapping
    ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }
    @GetMapping("{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }
    @PostMapping("create")
    ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(createUserDto));
    }
}
