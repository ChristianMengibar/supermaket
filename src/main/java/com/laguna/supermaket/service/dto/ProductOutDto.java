package com.laguna.supermaket.service.dto;

import com.laguna.supermaket.persistence.entity.Category;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductOutDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Double stock;
    private Category category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
