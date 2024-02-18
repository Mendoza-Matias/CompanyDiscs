package com.record.company.com.bussines;

import com.record.company.com.domain.dto.album.AlbumCreateDto;
import com.record.company.com.domain.dto.album.AlbumDto;
import com.record.company.com.domain.dto.album.AlbumInfoDto;
import com.record.company.com.domain.dto.album.AlbumTitleDto;

import java.util.List;

public interface IAlbumServices {


    List<AlbumDto> getAllAlbum();

    AlbumDto getAlbumById(int id);

    List <AlbumTitleDto> getAllAlbumByNameArtist(String nameArtist);

    List<AlbumInfoDto> getAllAlbumByMusicGenres (String musicGender);
    AlbumDto creteAlbum (int artistId,int musicGenderId,int albumFileId ,AlbumCreateDto album);

    AlbumDto updateAlbum (int id , int artistId,int musicGenderId , int albumFileId ,AlbumCreateDto album);

    AlbumDto deleteAlbum (int id);

}
