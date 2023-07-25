package com.ecommercewebsite.repository;

import com.ecommercewebsite.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    Brand findByName(String name);

}
