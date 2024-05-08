package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.TicketInDtoMapper;
import com.laguna.supermaket.persistence.entity.Ticket;
import com.laguna.supermaket.persistence.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    private final TicketInDtoMapper mapper;

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Ticket getById(Long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        return ticketOptional.orElse(null);
    }

    public Ticket createTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("No puede ser nulo.");
        }
        return ticketRepository.save(ticket);
    }

    public Ticket editTicket(Long id, Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("No puede ser nulo.");
        }

        Optional<Ticket> existingTicketOptional = ticketRepository.findById(id);
        if (existingTicketOptional.isEmpty()) {
            return null;
        }

        Ticket existingTicket = existingTicketOptional.get();
        existingTicket.setOpenDate(ticket.getOpenDate());
        existingTicket.setCloseDate(ticket.getCloseDate());
        existingTicket.setLine(ticket.getLine());
        existingTicket.setTotal(ticket.getTotal());

        return ticketRepository.save(existingTicket);
    }

    public void deleteTicket(Ticket ticket) {
        if (ticket == null || ticket.getId() == null || !ticketRepository.existsById(ticket.getId())) {
            throw new IllegalArgumentException("El ticket no existe");
        }
        ticketRepository.delete(ticket);
    }

}
