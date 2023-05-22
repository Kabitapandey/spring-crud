package com.internship.books.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NotAllowedException.class)
    public Map<String, Object> notAllowedExceptionHandler(NotAllowedException ex) {
        Map<String, Object> response = new HashMap<>();

        response.put("msg", ex.getMessage());

        return response;
    }
}
