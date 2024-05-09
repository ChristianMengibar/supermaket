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

}
