package com.ecommercewebsite.validator;


import com.ecommercewebsite.dto.CategoryDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDTO categoryDto) {
        List errors = new ArrayList<>();
        if(StringUtils.hasLength(categoryDto.getName()))
        return errors;
    }
}
