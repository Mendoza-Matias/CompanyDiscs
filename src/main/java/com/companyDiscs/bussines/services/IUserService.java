package com.companyDiscs.bussines.services;

import com.companyDiscs.domain.dto.user.CreateUserDto;
import com.companyDiscs.domain.dto.user.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> getAllUser();
    UserDto getUserById(Long id);
    UserDto createUser(CreateUserDto createUserDto);
    void modifyPassword(Long id, String password);
    boolean existUserWithEmail(String email);
    boolean thereIsEmptyFilm(CreateUserDto createUserDto);
}
