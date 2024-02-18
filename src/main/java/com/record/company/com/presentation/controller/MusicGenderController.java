package com.record.company.com.presentation.controller;

import com.record.company.com.bussines.IMusicGenresServices;
import com.record.company.com.domain.dto.musicGenders.CreateMusicGenderDto;
import com.record.company.com.domain.dto.musicGenders.MusicGenderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/musicGenres")
public class MusicGenderController {

    @Autowired
    private IMusicGenresServices musicGenderServices;

    @PreAuthorize("hasRole('ROLE_ADMIN')||hasRole('ROLE_USER') ")
    @GetMapping("/genresAll")
    public ResponseEntity<List <MusicGenderDto>> getAllMusicGender(){
        return ResponseEntity.ok(musicGenderServices.getAllMusicGenres());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')||hasRole('ROLE_USER') ")
    @GetMapping("{id}")
    public ResponseEntity<MusicGenderDto> getMusicGenderById(@PathVariable("id") int id){
        return ResponseEntity.ok(musicGenderServices.getMusicGenresById(id));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<MusicGenderDto> createMusicGender(@RequestBody CreateMusicGenderDto musicGenres){
        return ResponseEntity.created(URI.create("/api/v1/recordCompany/musicGender")).body(musicGenderServices.createMusicGenres(musicGenres));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<MusicGenderDto> updateMusicGender(@PathVariable("id") int id, @RequestBody CreateMusicGenderDto musicGenres){
        return ResponseEntity.ok(musicGenderServices.updateMusicGenres(id,musicGenres));
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<MusicGenderDto> deleteMusicGender (@PathVariable("id") int id){
        return ResponseEntity.ok(musicGenderServices.deleteMusicGenres(id));
    }

}
