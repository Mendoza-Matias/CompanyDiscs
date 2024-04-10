package com.companyDiscs.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "locations")
public class Country {
    @Id
    private Long id;
    @Column(name = "location")
    private String location;
    @Column(name = "city")
    private String city;
}
