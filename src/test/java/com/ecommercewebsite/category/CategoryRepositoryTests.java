package com.ecommercewebsite.category;

import com.ecommercewebsite.entity.Category;
import com.ecommercewebsite.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CategoryRepositoryTests {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testSaveCategory() {
        Category category = new Category();
        category.setName("Electronics");
        category.setAlias("electronics");
        category.setImage("electronics.jpg");
        category.setEnabled(true);

        Category savedCategory = categoryRepository.save(category);
        assertThat(savedCategory.getId()).isGreaterThan(0);

        Category retrievedCategory = categoryRepository.findById(savedCategory.getId()).orElse(null);
        assertThat(retrievedCategory).isNotNull();
        assertThat(retrievedCategory.getName()).isEqualTo(category.getName());
        assertThat(retrievedCategory.getAlias()).isEqualTo(category.getAlias());
        assertThat(retrievedCategory.getImage()).isEqualTo(category.getImage());
        assertThat(retrievedCategory.isEnabled()).isEqualTo(category.isEnabled());
    }

    @Test
    public void testUpdateCategory() {
        Category category = new Category();
        category.setName("Electronics");
        category.setAlias("electronics");
        category.setImage("electronics.jpg");
        category.setEnabled(true);

        Category savedCategory = categoryRepository.save(category);
        Category retrieveSubCategory = categoryRepository.findById(savedCategory.getId()).orElse(null);
        assertThat(retrieveSubCategory).isNotNull();
        assertThat(savedCategory.getId()).isEqualTo(retrieveSubCategory.getId());

        retrieveSubCategory.setName("Updated Electronics");
        retrieveSubCategory.setAlias("updated-electronics");
        retrieveSubCategory.setImage("updated-electronics.jpg");
        retrieveSubCategory.setEnabled(false);

        Category updatedCategory = categoryRepository.save(retrieveSubCategory);

        assertThat(updatedCategory).isNotNull();
        assertThat(updatedCategory.getName()).isEqualTo("Updated Electronics");
        assertThat(updatedCategory.getAlias()).isEqualTo("updated-electronics");
        assertThat(updatedCategory.getImage()).isEqualTo("updated-electronics.jpg");
        assertThat(updatedCategory.isEnabled()).isFalse();
    }

    @Test
    public void testDeleteCategory() {
        Category category = new Category();
        category.setName("Electronics");
        category.setAlias("electronics");
        category.setImage("electronics.jpg");
        category.setEnabled(true);

        Category savedCategory = categoryRepository.save(category);

        Category retrieveSubCategory = categoryRepository.findById(savedCategory.getId()).orElse(null);
        assertThat(retrieveSubCategory).isNotNull();
        assertThat(retrieveSubCategory.getId()).isEqualTo(category.getId());

        categoryRepository.delete(retrieveSubCategory);
        Category deletedCategory = categoryRepository.findById(savedCategory.getId()).orElse(null);
        assertThat(deletedCategory).isNull();
    }

    @Test
    public void testCreateSubcategory() {
        Category parentCategory = new Category();
        parentCategory.setName("Electronics");
        parentCategory.setAlias("electronics");
        parentCategory.setImage("electronics.jpg");
        parentCategory.setEnabled(true);

        Category savedCategory = categoryRepository.save(parentCategory);

        Category subcategory = new Category();
        subcategory.setName("Mobile Phones");
        subcategory.setAlias("mobile-phones");
        subcategory.setImage("mobile-phones.jpg");
        subcategory.setEnabled(true);
        subcategory.setParent(parentCategory);

        Category savedSubCategory = categoryRepository.save(subcategory);

        Category retrieveSubCategory = categoryRepository.findById(savedCategory.getId()).orElse(null);
        assertThat(savedSubCategory).isNotNull();
        assertThat(savedSubCategory.getParent()).isEqualTo(parentCategory);
    }
}
