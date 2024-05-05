package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.LineInDTOToTask;
import com.laguna.supermaket.persistence.entity.Line;
import com.laguna.supermaket.persistence.repository.LineRepository;
import com.laguna.supermaket.service.dto.LineInDTO;
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

    public Optional<Line> findById(Long id) {
        return lineRepository.findById(id);
    }

    public List<Line> findAll() {
        return lineRepository.findAll();
    }

    public Line createLine(LineInDTO lineInDTO) {
        Line line = mapper.map(lineInDTO);
        return this.lineRepository.save(line);
    }

    public void updateLine(Long id, LineInDTO lineInDTO) {
        Line line = mapper.map(lineInDTO);
        this.lineRepository.save(line);
    }

    public void deleteLine(LineInDTO lineInDTO) {
        Line line = mapper.map(lineInDTO);
        this.lineRepository.delete(line);
    }
}
