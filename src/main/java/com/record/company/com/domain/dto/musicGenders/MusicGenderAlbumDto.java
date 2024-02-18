package com.record.company.com.domain.dto.musicGenders;

import com.record.company.com.domain.entity.Album;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MusicGenderAlbumDto {

    private Integer id;

    private List<Album> album;
}
