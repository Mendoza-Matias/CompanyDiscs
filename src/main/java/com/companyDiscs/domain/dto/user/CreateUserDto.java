package com.companyDiscs.domain.dto.user;

import com.companyDiscs.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateUserDto {

    private Long id;

    private String userName;

    private String email;

    private String password;

}
