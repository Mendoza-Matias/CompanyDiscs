package com.record.company.com.bussines.servicesImpl;


import com.record.company.com.bussines.IUserServices;

import com.record.company.com.domain.dto.user.*;
import com.record.company.com.domain.entity.User;
import com.record.company.com.exception.NotFoundException;
import com.record.company.com.exception.UserException;
import com.record.company.com.persistence.repository.IPurchaseRepository;
import com.record.company.com.persistence.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServicesImpl implements IUserServices {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPurchaseRepository purchaseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUser() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(int id) {

        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User id not found"));
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public UserDto register (UserCreateDto user) {

        return modelMapper.map(userRepository.save(User.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .password(new BCryptPasswordEncoder().encode(user.getPassword()))
                        .rol(user.getRol())
                .build()),UserDto.class);
    }

    @Override
    public List<UserPurchaseDto> getPurchaseByUserId(int id) {
        return purchaseRepository.getPurchaseByUserId(id).stream().map(purchase -> modelMapper.map(purchase,UserPurchaseDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(int id, UserUpdateDto user) {

       Optional<User> userExist = userRepository.findById(id);
       if(userExist.isPresent()){

           User newUser = userExist.get();
            newUser.setName(user.getName());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

           return modelMapper.map(userRepository.save(newUser),UserDto.class);
       }else{
           throw new UserException("User not found");
       }
    }

    @Override
    public UserDto deleteUser(int id) {

        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User userDelete = user.get();
            userRepository.deleteById(id);
            return modelMapper.map(userDelete,UserDto.class);
        }else{
            throw new UserException("User not found");
        }
    }


}
