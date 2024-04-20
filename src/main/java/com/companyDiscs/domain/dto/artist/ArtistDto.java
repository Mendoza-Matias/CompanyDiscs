package com.companyDiscs.domain.dto.artist;

import com.companyDiscs.domain.dto.country.CountryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ArtistDto {

    private Long id;

    private String name;

    private CountryDto country;

}
