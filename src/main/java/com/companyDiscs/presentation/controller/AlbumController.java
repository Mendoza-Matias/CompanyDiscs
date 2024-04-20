package com.companyDiscs.presentation.controller;

import com.companyDiscs.bussines.services.IAlbumService;
import com.companyDiscs.domain.dto.album.AlbumDto;
import com.companyDiscs.domain.dto.album.CreateAlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/albums")
public class AlbumController {
    @Autowired
    private IAlbumService albumService;
    @GetMapping
    ResponseEntity<List<AlbumDto>> getAllAlbums(){
        return ResponseEntity.status(HttpStatus.OK).body(albumService.getAllAlbums());
    }
    @GetMapping("{id}")
    ResponseEntity<AlbumDto> getAlbumById(@PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(albumService.getAlbumById(id));
    }

    @GetMapping("artistName/{artist}")
    ResponseEntity<AlbumDto> getAlbumByNameArtist(@PathVariable(name = "artist") String artist){
        return ResponseEntity.status(HttpStatus.OK).body(albumService.getAlbumByNameArtist(artist));
    }

    @GetMapping("genderName/{gender}")
    ResponseEntity<AlbumDto> getAlbumByNameGender(@PathVariable(name = "gender") String gender){
        return ResponseEntity.status(HttpStatus.OK).body(albumService.getAlbumByNameGender(gender));
    }

    @PostMapping("create/{artistId}")
    ResponseEntity<AlbumDto> createAlbum(@PathVariable(name = "artistId") Long artistId, @RequestBody CreateAlbumDto createAlbumDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(albumService.createAlbum(artistId,createAlbumDto));
    }

    //AlbumDto uploadImageAlbum(Long id , MultipartFile file)

    @PutMapping("updateAlbum/{id}")
    ResponseEntity<AlbumDto> updateAlbum(@PathVariable(name = "id") Long id, @RequestBody CreateAlbumDto createAlbumDto){
       return ResponseEntity.status(HttpStatus.OK).body(albumService.updateAlbum(id,createAlbumDto));
    }

    @PutMapping("updateArtist/{id}/{artistId}")
    ResponseEntity<AlbumDto> updateArtistOfAlbum(@PathVariable(name = "id") Long id, @PathVariable(name = "artistId") Long artistId){
        return ResponseEntity.status(HttpStatus.OK).body(albumService.updateArtistOfAlbum(id,artistId));
    }
}
