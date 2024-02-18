package com.record.company.com.presentation.controller;

import com.record.company.com.bussines.IArtistServices;
import com.record.company.com.domain.dto.artist.ArtistDto;
import com.record.company.com.domain.dto.artist.ArtistNameDto;
import com.record.company.com.domain.dto.artist.CreateArtistDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/artist")
public class ArtistController {

    @Autowired
    private IArtistServices artistServices;

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
    @GetMapping("/artistAll")
    public ResponseEntity<List<ArtistDto>> getAllArtist(){
        return ResponseEntity.ok(artistServices.getAllArtist());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
    @GetMapping("{id}")
    public ResponseEntity<ArtistDto> getArtistById(@PathVariable("id") int id ){
        return ResponseEntity.ok(artistServices.getArtistById(id));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
    @GetMapping("/country")
    public ResponseEntity<List<ArtistNameDto>> getAllArtistByCountry(@RequestParam("name") String country){
        return ResponseEntity.ok(artistServices.getAllArtistByCountry(country));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping()
    public ResponseEntity<ArtistDto> createArtist (@RequestBody CreateArtistDto artist){
        return ResponseEntity.created(URI.create("/api/v1/recordCompany/artist")).body(artistServices.createArtist(artist));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<ArtistDto> updateArtist( @PathVariable("id") int id , @RequestBody CreateArtistDto artist){
        return ResponseEntity.ok(artistServices.updateArtist(id,artist));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<ArtistDto> deleteArtist(@PathVariable("id") int id){
        return ResponseEntity.ok(artistServices.deleteArtist(id));
    }
}
