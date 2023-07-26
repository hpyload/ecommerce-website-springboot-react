package com.ecommercewebsite.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Integer fieldValue;
    private final String message;
    private List<String> errors;

    public ResourceNotFoundException(String resourceName, String fieldName,
                                     Integer fieldValue,List<String> errors) {
        super();
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.message = String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue);
        this.errors = errors;
    }

    public ResourceNotFoundException(String message, List<String> errors) {
        super();
        this.message = message;
        this.errors = errors;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue) {
        super();
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.message = String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue);

    }

    public ResourceNotFoundException(String resourceName, String fieldName, String message) {
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.message = message;
    }
}
