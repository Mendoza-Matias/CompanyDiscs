package com.companyDiscs.domain.dto.album;

import com.companyDiscs.domain.dto.artist.ArtistDto;
import com.companyDiscs.domain.dto.gender.GenderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateAlbumDto {

    private String name;

    private ArtistDto artist;

    private int numberSongs;

    private Date publicationDate;

    private double price;

    private GenderDto gender;
}