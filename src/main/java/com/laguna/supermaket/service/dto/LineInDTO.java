package com.laguna.supermaket.service.dto;

import com.laguna.supermaket.persistence.entity.Ticket;
import lombok.Data;
import lombok.Setter;

@Data
public class LineInDTO {
    @Setter
    private Long id;
    private String product;
    private double quantity;
    private Ticket ticket;
}
