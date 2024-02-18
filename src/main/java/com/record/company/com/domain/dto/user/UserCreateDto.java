package com.record.company.com.domain.dto.user;

import com.record.company.com.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {

    private String name;

    private String email;

    private  String password;

    private Rol rol;
}
