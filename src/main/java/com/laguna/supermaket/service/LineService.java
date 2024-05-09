package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.LineInDtoMapper;
import com.laguna.supermaket.persistence.entity.Line;
import com.laguna.supermaket.persistence.repository.LineRepository;
import com.laguna.supermaket.service.dto.LineInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LineService {

    private final LineRepository lineRepository;

    private final LineInDtoMapper mapper;


    public LineService(LineRepository lineRepository, LineInDtoMapper mapper) {
        this.lineRepository = lineRepository;
        this.mapper = mapper;
    }
}
