package com.record.company.com.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Albums")
public class Album {

    private Integer id;

    @ManyToOne
    @JoinColumn(name = "artistId")
    private Artist artist;

    private String titleAlbum;

    private int numberSongs;

    private String AlbumImg;

    private Date publicationYear;

    @ManyToOne
    @JoinColumn(name = "genderId")
    private MusicGender musicGender;

    @ManyToMany(
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "album_pre_purchase",
            joinColumns = @JoinColumn(name = "pre_purchase_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private List<PrePurchase> prePurchase;

}
