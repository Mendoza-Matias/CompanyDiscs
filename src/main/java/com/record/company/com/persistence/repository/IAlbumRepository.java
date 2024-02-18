package com.record.company.com.persistence.repository;

import com.record.company.com.domain.dto.album.AlbumInfoDto;
import com.record.company.com.domain.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IAlbumRepository extends JpaRepository<Album,Integer> {

    @Query("SELECT a FROM Album a WHERE a.artist.nameArtist = :artist")
    List <Album> getAllAlbumByNameArtist(String artist);

    @Query("SELECT a FROM Album a WHERE a.musicGender.nameGender = :musicGenres")
    List<Album> getAllAlbumByMusicGenres (String musicGenres);

}
