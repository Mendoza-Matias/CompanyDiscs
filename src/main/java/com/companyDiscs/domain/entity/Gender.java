package com.companyDiscs.domain.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "genders")
public class Gender {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
}
