package com.companyDiscs.domain.entity;

import com.companyDiscs.domain.enums.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Client {
    @Id
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
