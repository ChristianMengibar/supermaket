package com.laguna.supermaket.mapper;

import com.laguna.supermaket.persistence.entity.Product;
import com.laguna.supermaket.service.dto.ProductInDto;
import com.laguna.supermaket.service.dto.ProductOutDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductInDtoMapper {

    ProductInDto productToProductInDto(Product product);
    ProductOutDto productToProductOutDto(Product product);
    Product productInDtoToProduct(ProductInDto productInDto);
}
