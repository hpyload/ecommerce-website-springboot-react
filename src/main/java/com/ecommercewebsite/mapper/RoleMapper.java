package com.ecommercewebsite.mapper;

import com.ecommercewebsite.dto.RoleDTO;
import com.ecommercewebsite.entity.user.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    private final ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RoleDTO mapToDto(Role category) {
        return modelMapper.map(category, RoleDTO.class);
    }

    public Role mapToEntity(RoleDTO categoryDto) {
        return modelMapper.map(categoryDto, Role.class);
    }
}
