package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.ProductInDtoMapper;
import com.laguna.supermaket.persistence.entity.Product;
import com.laguna.supermaket.persistence.repository.ProductRepository;
import com.laguna.supermaket.service.dto.ProductInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductInDtoMapper mapper;

    public ProductService(ProductRepository productRepository, ProductInDtoMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }
}
