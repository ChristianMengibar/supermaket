package com.laguna.supermaket.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private double quantity;
    private double price;
    private double total;
    @ManyToOne
    private Ticket ticket;

}
