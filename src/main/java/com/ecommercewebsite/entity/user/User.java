package com.ecommercewebsite.entity.user;

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
@Table(name = "users")
public class User extends IdBasedEntity implements Serializable {
    @Column(length = 128, nullable = false, unique = true)
    private String email;
    @Column(length = 45, nullable = false, unique = true)
    private String username;
    @Column(length = 64, nullable = false)
    private String password;
    @Column(name = "first_name", length = 45, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 45, nullable = false)
    private String lastName;
    @Column(length = 64)
    private String photos;
    private boolean enabled;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        this.roles.add(role);
    }

    @Transient
    public String getPhotosImagePath() {
        // add code
        return null;
    }

    @Transient
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean hasRole(String roleName) {

        for (Role role : roles) {
            if (role.getName().equals(roleName)) {
                return true;
            }
        }

        return false;
    }
}
