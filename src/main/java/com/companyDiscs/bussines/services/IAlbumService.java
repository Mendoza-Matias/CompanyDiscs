package com.companyDiscs.bussines.services;

import com.companyDiscs.domain.dto.album.AlbumDto;
import com.companyDiscs.domain.dto.album.CreateAlbumDto;
import com.companyDiscs.domain.dto.album.UpdateAlbumDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IAlbumService {
    List<AlbumDto> getAllAlbums();
    AlbumDto getAlbumById(Long id);
    AlbumDto getAlbumByNameArtist(String artist);
    AlbumDto getAlbumByNameGender(String gender);
    AlbumDto createAlbum(Long artistId,CreateAlbumDto createAlbumDto);
    AlbumDto uploadImageAlbum(Long id , MultipartFile file);
    AlbumDto updateAlbum(Long id, UpdateAlbumDto updateAlbumDto);
    AlbumDto updateArtistOfAlbum(Long id, Long artistId);
    AlbumDto deleteAlbum(Long id);
    boolean existAlbumWithName(String name);
}
