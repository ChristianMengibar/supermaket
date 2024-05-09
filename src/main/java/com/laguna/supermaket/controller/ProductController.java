package com.laguna.supermaket.controller;

import com.laguna.supermaket.persistence.entity.Product;
import com.laguna.supermaket.service.ProductService;
import com.laguna.supermaket.service.dto.ProductInDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


}
