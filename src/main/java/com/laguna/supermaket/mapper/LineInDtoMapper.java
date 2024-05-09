package com.laguna.supermaket.mapper;

import com.laguna.supermaket.persistence.entity.Line;
import com.laguna.supermaket.service.dto.LineInDto;
import com.laguna.supermaket.service.dto.LineOutDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LineInDtoMapper {
    LineInDto lineToLineInDto(Line line);
    LineOutDto lineToLineOutDto(Line line);
    Line lineInDtoToLine(LineInDto lineInDto);
}
