package com.ecommercewebsite.service;

import com.ecommercewebsite.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategoryById(Integer id);

    List<CategoryDTO> SubcategoriesByParentId(Integer id);

    List<CategoryDTO> getAllCategories();

    void deleteCategory(Integer id);

    void updateCategoryEnabledStatus(Integer id, boolean enabled);

}
