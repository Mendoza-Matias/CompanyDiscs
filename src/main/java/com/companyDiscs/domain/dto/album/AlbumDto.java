package com.companyDiscs.domain.dto.album;

import com.companyDiscs.domain.dto.artist.ArtistBasicInformationDto;
import com.companyDiscs.domain.dto.gender.GenderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AlbumDto {

    private Long id;

    private String name;

    private GenderDto gender;

    private ArtistBasicInformationDto artist;

    private int numberSongs;

    private LocalDate publicationDate;

    private BigDecimal price;

    private String imageUlr;

}
