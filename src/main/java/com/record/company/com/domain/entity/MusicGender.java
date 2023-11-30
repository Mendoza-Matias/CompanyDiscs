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
@Table(name = "MusicGenders")
public class MusicGender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nameGender")
    private String nameGender;

    @OneToMany(mappedBy = "musicGender" , fetch = FetchType.LAZY)
    private List <Album> album;
}
