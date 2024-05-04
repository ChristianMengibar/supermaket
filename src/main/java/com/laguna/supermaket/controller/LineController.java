package com.laguna.supermaket.controller;

import com.laguna.supermaket.persistence.entity.Line;
import com.laguna.supermaket.service.LineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/line")
public class LineController {

    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @GetMapping("/all")
    public List<Line> findAll() {
        return lineService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Line> findById(@PathVariable Long id) {
        Optional<Line> line = lineService.findById(id);
        return line.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
