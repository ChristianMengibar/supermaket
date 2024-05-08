package com.laguna.supermaket.service.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class TicketInDto {

    @Setter
    private Long id;
    private LocalDateTime openDate;
    @Column(nullable = true)
    private LocalDateTime closeDate;
}
