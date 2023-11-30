package com.record.company.com.bussines.services;

import com.record.company.com.domain.dto.user.CreateUserDto;
import com.record.company.com.domain.dto.user.PrePurchaseUserDto;
import com.record.company.com.domain.dto.user.UpdateUserDto;
import com.record.company.com.domain.dto.user.UserDto;

public interface IUserServices {

    UserDto getAllUser();

    UserDto getUserById();

    UserDto createUser(CreateUserDto createUserDto);

    UserDto updateUser(int id , UpdateUserDto updateUserDto);

    UserDto deleteUser(int id);

    PrePurchaseUserDto getPrePurchaseByUser (UserDto userDto);



}
