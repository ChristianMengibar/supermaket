package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.TicketInDTOToTask;
import com.laguna.supermaket.persistence.entity.Ticket;
import com.laguna.supermaket.persistence.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    private final TicketInDTOToTask ticketInDTOToTask;

    public TicketService(TicketRepository ticketRepository, TicketInDTOToTask ticketInDTOToTask) {
        this.ticketRepository = ticketRepository;
        this.ticketInDTOToTask = ticketInDTOToTask;
    }

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Ticket getById(Long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        return ticketOptional.orElse(null);
    }

    public Ticket createTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null");
        }
        return ticketRepository.save(ticket);
    }
}
