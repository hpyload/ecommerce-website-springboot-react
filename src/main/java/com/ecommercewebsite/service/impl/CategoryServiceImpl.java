package com.ecommercewebsite.service.impl;

import com.ecommercewebsite.dto.CategoryDTO;
import com.ecommercewebsite.entity.Category;
import com.ecommercewebsite.exception.InvalidResourceException;
import com.ecommercewebsite.exception.ResourceNotFoundException;
import com.ecommercewebsite.mapper.CategoryMapper;
import com.ecommercewebsite.repository.CategoryRepository;
import com.ecommercewebsite.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;


    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        List<String> errors = new ArrayList<>();
        String name = categoryDTO.getName();
        String alias = categoryDTO.getAlias();
        Integer id = categoryDTO.getId();

        Category categoryByName = categoryRepository.findByName(name);
        Category categoryByAlias = categoryRepository.findByAlias(alias);

        if (id == null || id == 0) {
            // Creating a new category
            if (categoryByName != null) {
                errors.add("Duplicate name of category");
            }
            if (categoryByAlias != null) {
                errors.add("Duplicate alias of category");
            }
        } else {
            // Updating an existing category
            if (categoryByName != null && !categoryByName.getId().equals(id)) {
                errors.add("Duplicate name of category");
            }
            if (categoryByAlias != null && !categoryByAlias.getId().equals(id)) {
                errors.add("Duplicate alias of category");
            }
        }

        if (!errors.isEmpty()) {
            throw new InvalidResourceException("Invalid resource exception", errors);
        }
        return categoryMapper.mapToDto(categoryRepository.save(categoryMapper.mapToEntity(categoryDTO)));
    }

    @Override
    public CategoryDTO getCategoryById(Integer id) {
        return categoryMapper.mapToDto(categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", id)));
    }

    @Override
    public List<CategoryDTO> SubcategoriesByParentId(Integer id) {
        return null;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", id));
        categoryRepository.delete(category);
    }

    @Override
    public void updateCategoryEnabledStatus(Integer id, boolean enabled) {

    }

}
