package com.companyDiscs.domain.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    private Country country;
}
