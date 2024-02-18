package com.record.company.com.bussines;

import com.record.company.com.domain.dto.user.*;

import java.util.List;

public interface IUserServices {

    List <UserDto> getAllUser();
    UserDto getUserById(int id);
    List <UserPurchaseDto> getPurchaseByUserId (int id);
    UserDto register (UserCreateDto user);

    UserDto updateUser(int id , UserUpdateDto user);
    UserDto deleteUser(int id);




}
