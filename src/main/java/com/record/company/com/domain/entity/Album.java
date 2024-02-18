package com.record.company.com.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_artist")
    private Artist artist;

    @Column(name = "name_album")
    private String nameAlbum;

    @Column(name= "number_songs")
    private int numberSongs;

    @OneToOne
    @JoinColumn(name = "id_albumImg")
    private AlbumImage albumImage;

    @Column(name = "year_publication")
    private Date yearPublication;

    @ManyToOne
    @JoinColumn(name = "id_musicGender")
    private MusicGenres musicGenres;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "album_purchase",joinColumns =
            @JoinColumn(name = "id_album",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_purchase",
                    referencedColumnName = "id")
    )
    private List <Purchase> purchase;

}
