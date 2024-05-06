package com.laguna.supermaket.mapper;

import com.laguna.supermaket.persistence.entity.Line;
import com.laguna.supermaket.service.dto.LineInDTO;
import org.springframework.stereotype.Component;

@Component
public class LineInDTOToTask implements IMapper<LineInDTO, Line> {
    @Override
    public Line map(LineInDTO in) {
        Line line = new Line();
        line.setProduct(in.getProduct());
        line.setQuantity(in.getQuantity());
        line.setTicket(in.getTicket());
        return line;
    }
}
