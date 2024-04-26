package com.companyDiscs.bussines.services.servicesImpl;

import com.companyDiscs.bussines.services.IUserService;
import com.companyDiscs.domain.dto.user.CreateUserDto;
import com.companyDiscs.domain.dto.user.UserDto;
import com.companyDiscs.domain.entity.User;
import com.companyDiscs.domain.enums.Rol;
import com.companyDiscs.exception.ClientException;
import com.companyDiscs.exception.NotFoundException;
import com.companyDiscs.persistence.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List <UserDto> getAllUser() {
        List<User> user = userRepository.findAll();
        return user.stream().map(usr -> modelMapper.map(usr,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("user not found"));
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public UserDto createUser(CreateUserDto createUserDto) {

        if(thereIsEmptyFilm(createUserDto)){
            throw new ClientException("there is empty film");
        }

        if(existUserWithEmail(createUserDto.getEmail())){
            throw new ClientException("email exist");
        }

        User user = modelMapper.map(createUserDto,User.class);
        user.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
        user.setRol(Rol.ADMIN);

        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    @Override
    public UserDto modifyPassword(Long id, String password) {

        User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("user not found"));

        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);

        modelMapper.map(user, UserDto.class);

        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public boolean existUserWithEmail(String email) {

        return userRepository.existsByEmail(email);

    }

    @Override
    public boolean thereIsEmptyFilm(CreateUserDto createUserDto) {
        return createUserDto.getUserName() == null || createUserDto.getEmail() == null || createUserDto.getPassword() == null;
    }
}
