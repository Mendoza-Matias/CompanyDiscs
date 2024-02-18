package com.record.company.com.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Builder
@Setter
@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "artist_name")
    private String nameArtist;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "artist" , fetch = FetchType.EAGER)
    private List <Album> album;



}
