package com.record.company.com.domain.dto.artist;

import com.record.company.com.domain.dto.album.AlbumDto;
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
public class ArtistDto {

    private Integer id;

    private String nameArtist;

    private String country;

}
