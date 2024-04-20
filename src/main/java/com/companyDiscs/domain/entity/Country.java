package com.companyDiscs.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "countries")

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Country {
    @Id
    private Long id;

    @Column(name = "location")
    private String location;

    @Column(name = "city")
    private String city;
}
