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
@RequiredArgsConstructor
public class LineService {

    private final LineRepository lineRepository;

    private final LineInDtoMapper mapper;

    public Optional<Line> findById(Long id) {
        return lineRepository.findById(id);
    }

    public List<Line> findAll() {
        return lineRepository.findAll();
    }

    public Line createLine(LineInDto lineInDTO) {
        Line line = mapper.map(lineInDTO);
        return this.lineRepository.save(line);
    }

    public void updateLine(Long id, LineInDto lineInDTO) {
        Line line = mapper.map(lineInDTO);
        this.lineRepository.save(line);
    }

    public void deleteLine(LineInDto lineInDTO) {
        Line line = mapper.map(lineInDTO);
        this.lineRepository.delete(line);
    }
}
