package com.ecommercewebsite.dto;

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
public class UserDTO {
    private Integer id;
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String photos;
    private boolean enabled;
    private Set<RoleDTO> roles = new HashSet<>();
}
