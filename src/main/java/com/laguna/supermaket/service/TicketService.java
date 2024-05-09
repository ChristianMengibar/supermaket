package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.TicketInDtoMapper;
import com.laguna.supermaket.persistence.entity.Ticket;
import com.laguna.supermaket.persistence.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    private final TicketInDtoMapper mapper;

    public TicketService(TicketRepository ticketRepository, TicketInDtoMapper mapper) {
        this.ticketRepository = ticketRepository;
        this.mapper = mapper;
    }
}
