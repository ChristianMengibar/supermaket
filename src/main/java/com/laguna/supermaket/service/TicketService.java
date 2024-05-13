package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.TicketInDtoMapper;
import com.laguna.supermaket.persistence.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    private final TicketInDtoMapper mapper;

    public TicketService(TicketRepository ticketRepository, TicketInDtoMapper mapper) {
        this.ticketRepository = ticketRepository;
        this.mapper = mapper;
    }

}
