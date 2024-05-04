package com.laguna.supermaket.service.dto;

import lombok.Data;
import lombok.Setter;

@Data
public class LineInDTO {
    @Setter
    private Long id;
    private String product;
    private double cuantity;
}
