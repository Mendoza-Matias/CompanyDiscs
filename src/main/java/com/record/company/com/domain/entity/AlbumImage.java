package com.record.company.com.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name="album_image")
public class AlbumImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_img")
    private  String nameImg;

    @Column(name = "type")
    private String type;

    @Column(name = "file_path")
    private String path;

    @Column(name="location")
    private String urlImageLocation;

    @OneToOne(mappedBy = "albumFile")
    private Album album;
}
