package com.companyDiscs.domain.dto.country;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CountryDto {

    private Long id;

    private String location;

    private String city;
}
