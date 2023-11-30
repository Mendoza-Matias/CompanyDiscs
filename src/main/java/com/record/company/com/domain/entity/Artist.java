package com.record.company.com.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "nameArtist")
    private String nameArtist;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "artist" , fetch = FetchType.LAZY)
    private List <Album> album;



}
