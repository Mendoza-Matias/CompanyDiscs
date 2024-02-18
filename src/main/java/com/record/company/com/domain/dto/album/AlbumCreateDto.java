package com.record.company.com.domain.dto.album;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumCreateDto {

    private String nameAlbum;

    private int numberSongs;

    private Date yearPublication;

}
