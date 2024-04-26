package com.companyDiscs.domain.dto.album;

import com.companyDiscs.domain.dto.artist.ArtistBasicInformationDto;
import com.companyDiscs.domain.dto.gender.GenderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlbumBasicInformationDto {
    private Long id;

    private String name;

    private GenderDto gender;

    private ArtistBasicInformationDto artist;
}
