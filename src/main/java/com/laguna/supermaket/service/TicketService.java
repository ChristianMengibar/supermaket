package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.TicketInDTOToTask;
import com.laguna.supermaket.persistence.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    private final TicketInDTOToTask ticketInDTOToTask;

    public TicketService(TicketRepository ticketRepository, TicketInDTOToTask ticketInDTOToTask) {
        this.ticketRepository = ticketRepository;
        this.ticketInDTOToTask = ticketInDTOToTask;
    }
}
