package com.example.projecttwobase.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionHandler extends RuntimeException {
    public ExceptionHandler() {
        super();
    }

    public ExceptionHandler(String message) {
        super(message);
    }

    public ExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }
}