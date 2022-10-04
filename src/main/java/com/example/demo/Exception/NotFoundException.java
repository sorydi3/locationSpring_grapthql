package com.example.demo.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Dog not found")
public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public NotFoundException(String message) {
        super(message);
    }
}
