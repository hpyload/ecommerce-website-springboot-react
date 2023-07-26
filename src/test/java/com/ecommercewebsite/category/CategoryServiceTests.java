package com.ecommercewebsite.category;

import com.ecommercewebsite.dto.CategoryDTO;
import com.ecommercewebsite.entity.Category;
import com.ecommercewebsite.exception.ResourceNotFoundException;
import com.ecommercewebsite.repository.CategoryRepository;
import com.ecommercewebsite.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTests {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    public void testCheckUnique_NewCategory_Valid() {
        String name = "New Category";
        String alias = "new-category";
        when(categoryRepository.findByName(name)).thenReturn(Optional.empty());
        when(categoryRepository.findByAlias(alias)).thenReturn(Optional.empty());

        String result = categoryService.checkUnique(null, name, alias);

        assertThat(result).isEqualTo("OK");
        verify(categoryRepository).findByName(name);
        verify(categoryRepository).findByAlias(alias);
    }

    @Test
    public void testCheckUnique_NewCategory_DuplicateName() {
        String name = "Existing Category";
        String alias = "new-category";
        Category existingCategory = new Category();
        when(categoryRepository.findByName(name)).thenReturn(Optional.of(existingCategory));
        when(categoryRepository.findByAlias(alias)).thenReturn(Optional.empty());

        String result = categoryService.checkUnique(null, name, alias);

        assertThat(result).isEqualTo("DuplicateName");
        verify(categoryRepository).findByName(name);
        verify(categoryRepository).findByAlias(alias);
    }

    @Test
    public void testCheckUnique_NewCategory_DuplicateAlias() {
        String name = "New Category";
        String alias = "existing-category";
        Category existingCategory = new Category();
        when(categoryRepository.findByName(name)).thenReturn(Optional.empty());
        when(categoryRepository.findByAlias(alias)).thenReturn(Optional.of(existingCategory));

        String result = categoryService.checkUnique(null, name, alias);

        assertThat(result).isEqualTo("DuplicateAlias");
        verify(categoryRepository).findByName(name);
        verify(categoryRepository).findByAlias(alias);
    }

    @Test
    public void testCheckUnique_ExistingCategory_Valid() {
        Integer categoryId = 1;
        String name = "Existing Category";
        String alias = "existing-category";
        Category existingCategory = new Category();
        existingCategory.setId(categoryId);
        when(categoryRepository.findByName(name)).thenReturn(Optional.of(existingCategory));
        when(categoryRepository.findByAlias(alias)).thenReturn(Optional.empty());

        String result = categoryService.checkUnique(categoryId, name, alias);

        assertThat(result).isEqualTo("OK");
        verify(categoryRepository).findByName(name);
        verify(categoryRepository).findByAlias(alias);
    }

    @Test
    public void testCheckUnique_ExistingCategory_DuplicateName() {
        Integer categoryId = 1;
        String name = "Existing Category";
        String alias = "new-category";
        Category existingCategory = new Category();
        existingCategory.setId(categoryId);
        when(categoryRepository.findByName(name)).thenReturn(Optional.of(existingCategory));
        when(categoryRepository.findByAlias(alias)).thenReturn(Optional.empty());

        String result = categoryService.checkUnique(categoryId, name, alias);

        assertThat(result).isEqualTo("DuplicateName");
        verify(categoryRepository).findByName(name);
        verify(categoryRepository).findByAlias(alias);
    }

    @Test
    public void testCheckUnique_ExistingCategory_DuplicateAlias() {
        Integer categoryId = 1;
        String name = "New Category";
        String alias = "existing-category";
        Category existingCategory = new Category();
        existingCategory.setId(categoryId);
        when(categoryRepository.findByName(name)).thenReturn(Optional.empty());
        when(categoryRepository.findByAlias(alias)).thenReturn(Optional.of(existingCategory));

        String result = categoryService.checkUnique(categoryId, name, alias);

        assertThat(result).isEqualTo("DuplicateAlias");
        verify(categoryRepository).findByName(name);
        verify(categoryRepository).findByAlias(alias);
    }
}
