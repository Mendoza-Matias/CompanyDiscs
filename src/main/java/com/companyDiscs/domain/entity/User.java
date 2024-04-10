package com.companyDiscs.domain.entity;

import com.companyDiscs.domain.enums.Rol;
import jakarta.persistence.*;
@Entity
@Table(name = "users")
public class User {
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
}
