package com.laguna.supermaket.mapper;

import com.laguna.supermaket.persistence.entity.Ticket;
import com.laguna.supermaket.service.dto.TicketInDto;
import com.laguna.supermaket.service.dto.TicketOutDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TicketInDtoMapper {

    TicketInDto ticketToTicketInDto(Ticket ticket);
    TicketOutDto ticketToTicketOutDto (Ticket ticket);
    Ticket ticketInDtoToTicket(TicketInDto ticketInDto);
}
