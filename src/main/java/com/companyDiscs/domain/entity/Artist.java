package com.companyDiscs.domain.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "artists")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Artist {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Country country;
}
