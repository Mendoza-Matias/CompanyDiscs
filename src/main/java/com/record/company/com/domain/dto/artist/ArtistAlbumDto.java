package com.record.company.com.domain.dto.artist;

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
public class ArtistAlbumDto {

    private Integer id;

    private String nameArtist;

}
