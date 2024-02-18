package com.record.company.com.bussines;

import com.record.company.com.domain.dto.musicGenders.CreateMusicGenderDto;
import com.record.company.com.domain.dto.musicGenders.MusicGenderDto;

import java.util.List;

public interface IMusicGenresServices {

    List<MusicGenderDto> getAllMusicGenres ();

    MusicGenderDto getMusicGenresById (int id);

    MusicGenderDto createMusicGenres (CreateMusicGenderDto musicGenres);

    MusicGenderDto updateMusicGenres (int id, CreateMusicGenderDto musicGenres);

    MusicGenderDto deleteMusicGenres (int id);


}
