package com.laguna.supermaket.mapper;

import com.laguna.supermaket.persistence.entity.Ticket;
import com.laguna.supermaket.service.dto.TicketInDTO;
import org.springframework.stereotype.Component;

@Component
public class TicketInDTOToTask implements IMapper<TicketInDTO, Ticket>{
    @Override
    public Ticket map(TicketInDTO in) {
        Ticket ticket = new Ticket();
        ticket.setOpenDate(in.getOpenDate());
        ticket.setCloseDate(in.getCloseDate());
        return null;
    }
}
