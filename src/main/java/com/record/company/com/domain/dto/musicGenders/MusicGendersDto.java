package com.record.company.com.domain.dto.musicGenders;

import com.record.company.com.domain.dto.album.AlbumDto;

import com.record.company.com.domain.entity.Album;
import com.record.company.com.domain.entity.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class MusicGendersDto {


    private Integer id;


    private String nameGender;

    private List <Album> album;
}
