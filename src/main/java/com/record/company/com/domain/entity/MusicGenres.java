package com.record.company.com.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "music_genres")
public class MusicGenres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "genres_name")
    private String nameGenres;

    @OneToMany(mappedBy = "musicGenres" , fetch = FetchType.LAZY)
    private List <Album> album;
}
