package com.laguna.supermaket.service.dto;

import lombok.Data;
import lombok.Setter;

@Data
public class ProductInDto {
    @Setter
    private Long id;
    private String name;
    private String description;
    private double price;
}
