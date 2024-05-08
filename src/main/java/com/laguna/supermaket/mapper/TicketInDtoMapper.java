package com.laguna.supermaket.mapper;

import com.laguna.supermaket.persistence.entity.Ticket;
import com.laguna.supermaket.service.dto.TicketInDto;
import org.mapstruct.Mapper;

@Mapper
public interface TicketInDtoMapper {

    TicketInDto ticketToTicketInDto(Ticket ticket);

    Ticket ticketInDtoToTicket(TicketInDto ticketInDto);
}
