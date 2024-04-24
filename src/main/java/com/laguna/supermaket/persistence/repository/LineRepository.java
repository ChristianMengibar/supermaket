package com.laguna.supermaket.persistence.repository;

import com.laguna.supermaket.persistence.entity.Line;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineRepository extends JpaRepository<Line, Long> {
    void delete(Line line);
    Line save(Line line);
}
