package com.companyDiscs.domain.dto.album;

import com.companyDiscs.domain.dto.artist.ArtistDto;
import com.companyDiscs.domain.dto.gender.GenderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AlbumDto {

    private Long id;

    private String name;

    private GenderDto gender;

    private ArtistDto artist;

    private int numberSongs;

    private LocalDate publicationDate;

    private double price;

    private String imageUlr;

}
