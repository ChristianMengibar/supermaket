package com.laguna.supermaket.persistence.repository;

import com.laguna.supermaket.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
