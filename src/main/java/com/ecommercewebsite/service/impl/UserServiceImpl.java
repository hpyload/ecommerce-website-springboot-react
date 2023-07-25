package com.ecommercewebsite.service.impl;

import com.ecommercewebsite.dto.UserDTO;
import com.ecommercewebsite.dto.RoleDTO;
import com.ecommercewebsite.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDTO getUserById(Integer id) {
        return null;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return null;
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return null;
    }

    @Override
    public UserDTO getUserByUsernameOrEmail(String username, String email) {
        return null;
    }

    @Override
    public String getPhotosImagePath(UserDTO userDTO) {
        // TODO : Implement the logic to retrieve the photos image path for the user
        return null;
    }

    @Override
    public String getFullName(UserDTO userDTO) {
        return userDTO.getFirstName() + " " + userDTO.getLastName();
    }

}
