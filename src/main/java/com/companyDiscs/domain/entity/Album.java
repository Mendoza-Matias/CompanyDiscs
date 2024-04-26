package com.companyDiscs.domain.entity;

import jakarta.persistence.*;
import jdk.jfr.Timespan;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "album")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Gender gender;

    @ManyToOne
    private Artist artist;

    @Column(name = "number_songs")
    private int numberSongs;

    @Column(name = "publication_date")
    @Temporal(TemporalType.DATE)
    private LocalDate publicationDate;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "price")
    private BigDecimal price;

    @JoinTable(
            name = "rel_album_client",
            joinColumns = @JoinColumn(name = "album_id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "client_id",nullable = false)
    )
    @ManyToMany()
    private List<Client> clients;
    public void addClient(Client client){ //method
        if(this.clients == null){
            clients = new ArrayList<>();
        }
        clients.add(client);
    }
}
