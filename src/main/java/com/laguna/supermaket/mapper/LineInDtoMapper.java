package com.laguna.supermaket.mapper;

import com.laguna.supermaket.persistence.entity.Line;
import com.laguna.supermaket.service.dto.LineInDto;
import org.mapstruct.Mapper;

@Mapper
public interface LineInDtoMapper {
    LineInDto lineToLineInDto(Line line);
    Line lineInDtoToLine(LineInDto lineInDto);
}
