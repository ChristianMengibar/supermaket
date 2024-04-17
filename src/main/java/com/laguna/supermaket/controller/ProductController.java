package com.laguna.supermaket.controller;

import com.laguna.supermaket.persistence.entity.Product;
import com.laguna.supermaket.service.ProductService;
import com.laguna.supermaket.service.dto.ProductInDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Camino hacia el controlador
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create") //Crear elementos
    public Product createProduct(@RequestBody ProductInDTO productInDTO) {
        return this.productService.createProduct(productInDTO);
    }

    @GetMapping("/all")
    public List<Product> findAll(){
        return this.productService.findAll();
    }

}
