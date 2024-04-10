package com.companyDiscs.domain.dto.user;

import com.companyDiscs.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Rol rol;
}
