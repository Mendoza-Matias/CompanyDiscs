package com.record.company.com.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "prePurchase")
public class PrePurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number_booking")
    private int numberBooking;

    @Column(name = "date_booking")
    private Date dateBooking;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToMany(mappedBy = "prePurchase")
    private List <Album> album;


}
