package com.record.company.com.bussines.services;

import com.record.company.com.domain.dto.artist.ArtistAlbumDto;
import com.record.company.com.domain.dto.artist.ArtistDto;
import com.record.company.com.domain.dto.artist.CreateArtistDto;

import java.util.List;

public interface IArtistServices {

    List <ArtistDto> getAllArtist ();

    ArtistDto getArtistById (int id);

    ArtistDto createArtist(CreateArtistDto artist);

    ArtistDto updateArtist(CreateArtistDto artist);

    ArtistDto deleteArtist(int id);

    ArtistAlbumDto getAlbumByArtist (String nameArtist);

    ArtistDto getArtistByName (String nameArtist);



}
