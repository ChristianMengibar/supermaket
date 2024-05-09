package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.TicketInDTOToTask;
import com.laguna.supermaket.persistence.entity.Ticket;
import com.laguna.supermaket.persistence.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Ticket getById(Long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        return ticketOptional.orElse(null);
    }

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
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
        if (!existingTicketOptional.isPresent()) {
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

    public Ticket openTicket() {
        Ticket ticket = new Ticket();
        ticket.setOpenDate(LocalDateTime.now());

        // Guardar el ticket en la base de datos
        return ticketRepository.save(ticket);
    }

}
