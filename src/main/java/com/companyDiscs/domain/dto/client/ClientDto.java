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
public class ClientDto {

    private Long id;

    private String name;

    private Rol rol;
}
