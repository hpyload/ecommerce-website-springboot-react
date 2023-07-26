package com.ecommercewebsite.dto;

import com.ecommercewebsite.entity.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Integer id;
    private String name;
    private String alias;
    private String image;
    private boolean enabled;
    private boolean hasChildren;
    private Category parent;
    private Set<Category> children = new HashSet<>();
    private String allParentIDs;
    private boolean customerCanReview;
    private boolean reviewedByCustomer;
}
