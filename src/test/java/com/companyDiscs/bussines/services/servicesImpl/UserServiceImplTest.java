package com.companyDiscs.bussines.services.servicesImpl;

import com.companyDiscs.domain.dto.user.CreateUserDto;
import com.companyDiscs.domain.dto.user.UserDto;
import com.companyDiscs.domain.entity.User;
import com.companyDiscs.domain.enums.Rol;
import com.companyDiscs.persistence.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepository userRepository;

    @Spy
    private ModelMapper modelMapper = new ModelMapper();

    private CreateUserDto createUserDto;

    private UserDto userDto;

    @BeforeEach
    void setup(){

        userDto = UserDto.builder()
                .id(1L)
                .Username("jack")
                .build();

        createUserDto = CreateUserDto.builder()
                .userName("jack")
                .email("jack@gmail.com")
                .password("jack12345")
                .build();
    }

    @Test
    void createUser() {

        User user = modelMapper.map(userDto,User.class);
        user.setRol(Rol.ADMIN);

        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);

        UserDto service = userServiceImpl.createUser(createUserDto);

        assertAll(
                ()-> assertEquals(1L,service.getId()),
                ()-> assertEquals("jack",service.getUsername())
        );
    }

    @Test
    void modifyPassword() {
        User user = User.builder()
                .id(1L)
                .password("oldPassword")
                .build();

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        userServiceImpl.modifyPassword(1L,"newPassword");

        Optional<User> updateUser = userRepository.findById(1L);

        assertTrue(updateUser.isPresent());

        assertEquals("newPassword",updateUser.get().getPassword());

    }
}