package com.laguna.supermaket.mapper;

import com.laguna.supermaket.persistence.entity.Category;
import com.laguna.supermaket.service.dto.CategoryInDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryInDTOToTask implements IMapper<CategoryInDTO, Category> {

    @Override
    public Category map(CategoryInDTO in) {
        Category category = new Category();
        category.setName(in.getName());
        category.setDescription(in.getDescription());
        return category;
    }
}
