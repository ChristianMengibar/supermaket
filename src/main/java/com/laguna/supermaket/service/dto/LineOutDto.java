package com.laguna.supermaket.service.dto;

import com.laguna.supermaket.persistence.entity.Ticket;
import lombok.Data;

@Data
public class LineOutDto {
    private Long id;
    private String product;
    private double quantity;
    private double price;
    private double total;
    private Ticket ticket;
}
