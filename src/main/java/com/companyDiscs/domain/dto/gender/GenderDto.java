package com.companyDiscs.domain.dto.gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GenderDto {

    private Long id;
    
    private String name;
}
