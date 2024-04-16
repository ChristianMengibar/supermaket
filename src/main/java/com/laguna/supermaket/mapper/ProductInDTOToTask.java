package com.laguna.supermaket.mapper;

import com.laguna.supermaket.persistence.entity.Product;
import com.laguna.supermaket.service.dto.ProductInDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductInDTOToTask implements IMapper<ProductInDTO, Product>{
    //Aqui solo ponemos lo que este en el Dto
    @Override
    public Product map(ProductInDTO in) {
        Product product = new Product();
        product.setName(in.getName());
        product.setDescription(in.getDescription());
        return product;
    }
}
