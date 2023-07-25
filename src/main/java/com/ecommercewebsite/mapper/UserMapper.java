package com.ecommercewebsite.mapper;

import com.ecommercewebsite.dto.UserDTO;
import com.ecommercewebsite.entity.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO mapToDto(User category) {
        return modelMapper.map(category, UserDTO.class);
    }

    public User mapToEntity(UserDTO categoryDto) {
        return modelMapper.map(categoryDto, User.class);
    }
}
