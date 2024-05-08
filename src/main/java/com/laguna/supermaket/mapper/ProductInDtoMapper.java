package com.laguna.supermaket.mapper;

import com.laguna.supermaket.persistence.entity.Product;
import com.laguna.supermaket.service.dto.ProductInDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProductInDtoMapper {

    ProductInDto productToProductInDto(Product product);

    Product productInDtoToProduct(ProductInDto productInDto);
}
