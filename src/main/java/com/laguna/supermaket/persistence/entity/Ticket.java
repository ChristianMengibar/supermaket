package com.laguna.supermaket.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime openDate;
    @Column(nullable = true)
    private LocalDateTime closeDate;
    @OneToMany
    private List<Line> line;
    private double total;
}
