package com.ecommercewebsite.entity;

import com.ecommercewebsite.IdBasedEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brands")
public class Brand extends IdBasedEntity implements Serializable {
    @Column(nullable = false, length = 45, unique = true)
    private String name;
    @Column(nullable = false, length = 128, unique = true)
    private String logo;
    @ManyToMany
    @JoinTable(
            name = "brands_categories",
            joinColumns = @JoinColumn(name = "brand_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();
}
