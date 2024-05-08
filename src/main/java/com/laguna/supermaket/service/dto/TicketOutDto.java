package com.laguna.supermaket.service.dto;

import com.laguna.supermaket.persistence.entity.Line;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TicketOutDto {
    private Long id;
    private LocalDateTime openDate;
    private LocalDateTime closeDate;
    private List<Line> line;
    private double total;
}
