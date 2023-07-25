package com.ecommercewebsite.entity.user.product;

import com.ecommercewebsite.IdBasedEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_images")
public class ProductImage extends IdBasedEntity implements Serializable {
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
