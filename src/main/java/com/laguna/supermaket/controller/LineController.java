package com.laguna.supermaket.controller;

import com.laguna.supermaket.persistence.entity.Line;
import com.laguna.supermaket.service.LineService;
import com.laguna.supermaket.service.dto.LineInDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/line")
public class LineController {

    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Line> findById(@PathVariable Long id) {
        Optional<Line> line = lineService.findById(id);
        return line.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<Line> findAll() {
        return lineService.findAll();
    }

    @PostMapping("/create")
    public Line createLine(@RequestBody LineInDto lineInDTO) {
        return lineService.createLine(lineInDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateLine(@PathVariable Long id, @RequestBody LineInDto lineInDTO) {
        try {
            lineService.updateLine(id, lineInDTO);
            return ResponseEntity.ok("Line actualizado.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar. " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteLine(@RequestBody LineInDto lineInDTO) {
        try {
            lineService.deleteLine(lineInDTO);
            return ResponseEntity.ok("Line borrada.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al borrar." + e.getMessage());
        }
    }
}
