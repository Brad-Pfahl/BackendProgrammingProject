package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name="vacation")
@Getter
@Setter
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "vacation_title")
    private String vacation_title;

    @Column(name = "description")
    private String description;

    @Column(name = "travel_price")
    private BigDecimal travel_price;

    @Column(name = "image_URL")
    private String image_URL;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @OneToMany(mappedBy = "vacation", fetch = FetchType.EAGER)
    private Set<Excursion> excursions;
}
