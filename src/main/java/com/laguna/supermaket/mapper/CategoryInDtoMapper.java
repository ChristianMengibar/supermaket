package com.laguna.supermaket.mapper;

import com.laguna.supermaket.persistence.entity.Category;
import com.laguna.supermaket.service.dto.CategoryInDto;
import com.laguna.supermaket.service.dto.CategoryOutDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CategoryInDtoMapper {

    CategoryInDto categoryToCategoryInDto(Category category);

    CategoryOutDto categoryToCategoryOutDto(Category category);

    Category categoryInDtoToCategory(CategoryInDto categoryInDto);
}
