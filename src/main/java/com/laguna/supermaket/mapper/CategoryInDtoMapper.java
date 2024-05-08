package com.laguna.supermaket.mapper;

import com.laguna.supermaket.persistence.entity.Category;
import com.laguna.supermaket.service.dto.CategoryInDto;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryInDtoMapper {

    CategoryInDto categoryToCategoryInDto(Category category);

    Category categoryInDtoToCategory(CategoryInDto categoryInDto);
}
