package com.laguna.supermaket.controller;

import com.laguna.supermaket.persistence.entity.Ticket;
import com.laguna.supermaket.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        try {
            Ticket ticket = ticketService.getById(id);
            return ResponseEntity.ok(ticket);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/all")
    public List<Ticket> getAllTickets() {
        return ticketService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        try {
            Ticket createdTicket = ticketService.createTicket(ticket);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Ticket> editTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        Ticket editedTicket = ticketService.editTicket(id, ticket);
        if (editedTicket != null) {
            return ResponseEntity.ok(editedTicket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTicket(@RequestBody Ticket ticket) {
        ticketService.deleteTicket(ticket);
        return ResponseEntity.ok("Ticket eliminado correctamente.");
    }

    @PostMapping("/open")
    public ResponseEntity<Ticket> openTicket() {
        try {
            Ticket openedTicket = ticketService.openTicket();
            return ResponseEntity.status(HttpStatus.CREATED).body(openedTicket);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); //Respuesta vacia con codigo de estado 404
        }
    }
}
