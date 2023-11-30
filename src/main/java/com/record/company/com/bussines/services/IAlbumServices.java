package com.record.company.com.bussines.services;

import com.record.company.com.domain.dto.album.AlbumCreateDto;
import com.record.company.com.domain.dto.album.AlbumDto;
import com.record.company.com.domain.dto.album.AlbumMusicGenderDto;

import java.util.List;

public interface IAlbumServices {


    List<AlbumDto> getAllAlbum();

    AlbumDto getAlbumById(int id);

    List <AlbumDto> getAllAlbumByArtist (String nameArtist);

    AlbumDto creteAlbum (AlbumCreateDto albumCreateDto);

    AlbumDto updateAlbum (int id , AlbumCreateDto albumCreateDto);

    AlbumDto deleteAlbum (int id);

    List <AlbumDto> getAlbumByGender (AlbumMusicGenderDto gender);

}
