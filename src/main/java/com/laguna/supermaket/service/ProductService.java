package com.laguna.supermaket.service;

import com.laguna.supermaket.mapper.ProductInDTOToTask;
import com.laguna.supermaket.persistence.entity.Product;
import com.laguna.supermaket.persistence.repository.ProductRepository;
import com.laguna.supermaket.service.dto.ProductInDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    //Se hace con Optional porque el valor puede ser nulo o no presente.
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(ProductInDTO productInDTO) {
        Product product = mapper.map(productInDTO);
        this.productRepository.delete(product);
    }

    //public Product updateProduct
    public void updateProduct(ProductInDTO productInDTO) {
        Product product = mapper.map(productInDTO);
        this.productRepository.save(product);
        //return this.
    }

    public void stockModify(Long id, double difference) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado."));

        product.setStock(product.getStock() + difference);

        if (product.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }

        productRepository.save(product);
    }
}
