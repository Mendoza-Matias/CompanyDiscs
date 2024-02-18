package com.record.company.com.presentation.controller;

import com.record.company.com.bussines.IUserServices;
import com.record.company.com.domain.dto.user.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserServices userServices;

    @Autowired
    private ModelMapper modelMapper;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(userServices.getAllUser());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") int id){
        return ResponseEntity.ok(userServices.getUserById(id));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER') ")
    @GetMapping("purchases/{id}")
    public List<UserPurchaseDto> getPurchaseByUserId (@PathVariable("id") int id){
        return userServices.getPurchaseByUserId(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") int id, @RequestBody UserUpdateDto user){
        return ResponseEntity.ok(userServices.updateUser(id,user));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER') ")
    @DeleteMapping("{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable("id") int id){
        return ResponseEntity.ok(userServices.deleteUser(id));
    }
}
