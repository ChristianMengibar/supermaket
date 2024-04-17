package com.laguna.supermaket.persistence.repository;

import com.laguna.supermaket.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {



}
