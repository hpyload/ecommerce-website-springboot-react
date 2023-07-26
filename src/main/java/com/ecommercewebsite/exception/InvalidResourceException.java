package com.ecommercewebsite.exception;

import lombok.Getter;

import java.util.List;
@Getter
public class InvalidResourceException extends RuntimeException {

    private final List<String> errors;
    public InvalidResourceException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }
}
