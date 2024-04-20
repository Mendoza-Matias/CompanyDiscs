package com.companyDiscs.domain.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "genders")

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gender {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;
}
