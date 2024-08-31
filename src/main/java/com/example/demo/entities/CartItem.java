package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.*;

@Entity
@Table(name="cart_item")
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="vacation_id",nullable = false)
    private Vacation vacation;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="excursion_cartitem", joinColumns = @JoinColumn(name = "cart_item_id"), inverseJoinColumns = @JoinColumn(name="excurstion_id"))
    private Set<Excursion> excursions;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    private Cart cart;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;
}
