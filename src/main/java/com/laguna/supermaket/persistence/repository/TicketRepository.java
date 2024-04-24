package com.laguna.supermaket.persistence.repository;

import com.laguna.supermaket.persistence.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository <Ticket, Long> {
    void delete (Ticket ticket);
    Ticket save(Ticket ticket);
}
