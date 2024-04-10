package com.companyDiscs.domain.dto.artist;

import com.companyDiscs.domain.dto.country.CountryDto;
import com.companyDiscs.domain.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateArtistDto {

    private String name;

    private CountryDto country;

}
