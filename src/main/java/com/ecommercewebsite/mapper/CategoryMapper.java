package com.ecommercewebsite.mapper;

import com.ecommercewebsite.dto.CategoryDTO;
import com.ecommercewebsite.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    private final ModelMapper modelMapper;

    public CategoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CategoryDTO mapToDto(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    public Category mapToEntity(CategoryDTO categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }
}
