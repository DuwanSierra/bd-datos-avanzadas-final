package com.udistrital.controlprojectsbackend.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException{
    private HttpStatus statusCode;
    private String statusDescription;
    private String message;
    public NotFoundException(String _message, String _statusDescription) {
        statusCode = HttpStatus.NOT_FOUND;
        statusDescription = _statusDescription;
        message = _message;
    }
}
