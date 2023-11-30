package com.record.company.com.domain.dto.album;

import com.record.company.com.domain.entity.Artist;
import com.record.company.com.domain.entity.MusicGender;
import com.record.company.com.domain.entity.PrePurchase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {

    private Integer id;

    private Artist artist;

    private String titleAlbum;

    private int numberSongs;

    private Date publicationYear;

    private MusicGender musicGender;

}
