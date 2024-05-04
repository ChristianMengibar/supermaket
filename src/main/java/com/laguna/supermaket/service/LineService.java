package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.LineInDTOToTask;
import com.laguna.supermaket.persistence.entity.Line;
import com.laguna.supermaket.persistence.repository.LineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LineService {

    private final LineRepository lineRepository;

    private final LineInDTOToTask mapper;

    public LineService(LineRepository lineRepository, LineInDTOToTask mapper) {
        this.lineRepository = lineRepository;
        this.mapper = mapper;
    }

    public List<Line> findAll() {
        return lineRepository.findAll();
    }

    public Optional<Line> findById(Long id) {
        return lineRepository.findById(id);
    }
}
