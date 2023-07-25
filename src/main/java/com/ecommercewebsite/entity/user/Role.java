package com.ecommercewebsite.entity.user;

import com.ecommercewebsite.IdBasedEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends IdBasedEntity implements Serializable {
    @Column(length = 40, nullable = false, unique = true)
    private String name;
    @Column(length = 150, nullable = false)
    private String description;
}
