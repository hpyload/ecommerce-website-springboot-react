package com.ecommercewebsite.handler;

import com.ecommercewebsite.exception.InvalidResourceException;
import com.ecommercewebsite.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorDTO errorDto = new ErrorDTO(new Date(),
                                ErrorCode.RESOURCE_NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidResourceException.class)
    public ResponseEntity<ErrorDTO> handleInvalidResourceException(InvalidResourceException exception) {
        ErrorDTO errorDto = new ErrorDTO(new Date(),
                ErrorCode.RESOURCE_NOT_VALID, exception.getMessage(),
                exception.getErrors());
        return new ResponseEntity<>(errorDto,HttpStatus.BAD_REQUEST);
    }
}
