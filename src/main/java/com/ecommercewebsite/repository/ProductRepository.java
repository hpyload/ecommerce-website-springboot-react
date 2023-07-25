package com.ecommercewebsite.repository;

import com.ecommercewebsite.entity.user.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);

    @Query("UPDATE Product p SET p.enabled = ?2 WHERE p.id = ?1")
    @Modifying
    void updateEnabledStatus(Integer id, boolean enabled);

    Long countById(Integer id);


    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1% "
            + "OR p.shortDescription LIKE %?1% "
            + "OR p.fullDescription LIKE %?1% "
            + "OR p.brand.name LIKE %?1% "
            + "OR p.category.name LIKE %?1%")
    Product findAll(String keyword);

    @Query("SELECT p FROM Product p WHERE p.category.id = ?1 "
            + "OR p.category.allParentIDs LIKE %?2%")
    Product findAllInCategory(Integer categoryId, String categoryIdMatch);

    @Query("SELECT p FROM Product p WHERE (p.category.id = ?1 "
            + "OR p.category.allParentIDs LIKE %?2%) AND "
            + "(p.name LIKE %?3% "
            + "OR p.shortDescription LIKE %?3% "
            + "OR p.fullDescription LIKE %?3% "
            + "OR p.brand.name LIKE %?3% "
            + "OR p.category.name LIKE %?3%)")
    Product searchInCategory(Integer categoryId, String categoryIdMatch, String keyword);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    Product searchProductsByName(String keyword);

//    @Query("Update Product p SET p.averageRating = COALESCE((SELECT AVG(r.rating) FROM Review r WHERE r.product.id = ?1), 0),"
//            + " p.reviewCount = (SELECT COUNT(r.id) FROM Review r WHERE r.product.id =?1) "
//            + "WHERE p.id = ?1")
//    @Modifying
//    void updateReviewCountAndAverageRating(Integer productId);
}
