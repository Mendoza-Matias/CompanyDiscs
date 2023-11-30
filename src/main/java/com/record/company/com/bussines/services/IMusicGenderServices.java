package com.record.company.com.bussines.services;

import com.record.company.com.domain.dto.musicGenders.MusicGendersAlbumDto;
import com.record.company.com.domain.dto.musicGenders.CreateMusicGendersDto;
import com.record.company.com.domain.dto.musicGenders.MusicGendersDto;

import java.util.List;

public interface IMusicGenderServices {

    List<MusicGendersDto> getAllMusicGenders ();

    MusicGendersDto getMusicGendersById (int id);

    MusicGendersDto createMusicGenders (CreateMusicGendersDto musicGender);

    MusicGendersDto updateMusicGenders (CreateMusicGendersDto musicGender);

    MusicGendersDto deleteMusicGenders (int id);

     MusicGendersAlbumDto getAllAlbumByMusicGender(String musicGender);

}
