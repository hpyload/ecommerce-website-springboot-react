package com.ecommercewebsite.repository;

import com.ecommercewebsite.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM Category c WHERE c.parent.id IS NULL")
    List<Category> findRootCategories();

//    @Query("SELECT c FROM Category c WHERE c.parent.id is NULL")
//    Page<Category> findRootCategories(Pageable pageable);

    @Query("SELECT c FROM Category c WHERE c.parent.id = ?1")
    List<Category> findSubcategoriesByParentId(Integer parentId);

//    @Query("SELECT c FROM Category c WHERE c.parent.id = ?1")
//    Page<Category> findSubcategoriesByParentId(Integer parentId, Pageable pageable);

//    @Query("SELECT c FROM Category c WHERE c.name LIKE %?1%")
//    Page<Category> search(String keyword, Pageable pageable);

    Category findByName(String name);

    Category findByAlias(String alias);

    @Query("UPDATE Category c SET c.enabled = ?2 WHERE c.id = ?1")
    @Modifying
    void updateEnabledStatus(Integer id, boolean enabled);

    Integer countById(Integer id);
}