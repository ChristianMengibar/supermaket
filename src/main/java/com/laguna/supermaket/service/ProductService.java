package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.ProductInDTOToTask;
import com.laguna.supermaket.persistence.entity.Product;
import com.laguna.supermaket.persistence.repository.ProductRepository;
import com.laguna.supermaket.service.dto.ProductInDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    //Para usar el mapper lo identamos en la clase.
    private final ProductInDTOToTask mapper;

    //Buena práctica siempre con constructor.
    public ProductService(ProductRepository productRepository, ProductInDTOToTask mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public Product createProduct(ProductInDTO productInDTO) {
        //Objeto ProductInDTO mapeado a product.
        Product product = mapper.map(productInDTO);
        return this.productRepository.save(product);
    }
}
