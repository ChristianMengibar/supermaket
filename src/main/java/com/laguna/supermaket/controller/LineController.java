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

}
