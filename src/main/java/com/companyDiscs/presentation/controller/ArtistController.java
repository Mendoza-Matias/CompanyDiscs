package com.companyDiscs.presentation.controller;

import com.companyDiscs.bussines.services.IArtistService;
import com.companyDiscs.domain.dto.artist.ArtistDto;
import com.companyDiscs.domain.dto.artist.CreateArtistDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/artist")
public class ArtistController {
    @Autowired
    private IArtistService artistService;

    @GetMapping
    ResponseEntity<List<ArtistDto>> getAllArtist(){
        return ResponseEntity.status(HttpStatus.OK).body(artistService.getAllArtist());
    }

    @GetMapping("{id}")
    ResponseEntity<ArtistDto> getArtistById(@PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(artistService.getArtistById(id));
    }

    @PostMapping("create")
    ResponseEntity<ArtistDto> CreateArtist(@RequestBody CreateArtistDto createArtistDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(artistService.CreateArtist(createArtistDto));
    }

    @PutMapping("{id}")
    ResponseEntity<ArtistDto> updateArtist(@PathVariable(name = "id") Long id, @RequestBody CreateArtistDto createArtistDto){
        return ResponseEntity.status(HttpStatus.OK).body(artistService.updateArtist(id,createArtistDto));
    }
}
