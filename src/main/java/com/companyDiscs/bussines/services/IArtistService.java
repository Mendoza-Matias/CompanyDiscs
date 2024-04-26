package com.companyDiscs.bussines.services;

import com.companyDiscs.domain.dto.artist.ArtistDto;
import com.companyDiscs.domain.dto.artist.CreateArtistDto;
import com.companyDiscs.domain.dto.artist.UpdateArtistDto;
import com.companyDiscs.domain.dto.user.CreateUserDto;

import java.util.List;

public interface IArtistService {
    List<ArtistDto> getAllArtist();
    ArtistDto getArtistById(Long id);
    ArtistDto CreateArtist(CreateArtistDto createArtistDto);
    ArtistDto updateArtist(Long id, UpdateArtistDto updateArtistDto);
    boolean existArtistWithName(String name);
    boolean thereIsEmptyFilm(CreateArtistDto createArtistDto);
}
