package com.laguna.supermaket.controller;

import com.laguna.supermaket.persistence.entity.Product;
import com.laguna.supermaket.service.ProductService;
import com.laguna.supermaket.service.dto.ProductInDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Camino hacia el controlador
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping //Crear elementos
    public Product createProduct(@RequestBody ProductInDTO productInDTO) {
        return this.productService.createProduct(productInDTO);
    }
}
