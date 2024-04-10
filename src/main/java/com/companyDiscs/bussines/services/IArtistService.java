package com.companyDiscs.bussines.services;

import com.companyDiscs.domain.dto.artist.ArtistDto;
import com.companyDiscs.domain.dto.artist.CreateArtistDto;

import java.util.List;

public interface IArtistService {
    List<ArtistDto> getAllArtist();
    ArtistDto getArtistById(Long id);
    ArtistDto CreateArtist(CreateArtistDto createArtistDto , Long countryId);
    ArtistDto updateArtist(Long id , CreateArtistDto createArtistDto);
    boolean existArtistWithName(String name);
}
