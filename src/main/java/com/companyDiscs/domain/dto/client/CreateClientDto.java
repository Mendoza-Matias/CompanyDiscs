package com.companyDiscs.domain.dto.client;

import com.companyDiscs.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateClientDto {

    private Long id;

    private String name;

    private String email;

    private String password;

}
