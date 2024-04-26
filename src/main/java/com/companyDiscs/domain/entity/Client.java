package com.companyDiscs.domain.entity;

import com.companyDiscs.domain.enums.Rol;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @ManyToMany(mappedBy = "clients")
    private List<Album> albums; //relation with album
}
