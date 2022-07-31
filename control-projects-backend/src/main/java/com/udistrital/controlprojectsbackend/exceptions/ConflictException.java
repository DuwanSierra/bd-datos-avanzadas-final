package com.udistrital.controlprojectsbackend.exceptions;
import org.springframework.http.HttpStatus;

public class ConflictException extends RuntimeException {
    private HttpStatus statusCode;
    private String statusDescription;

    private String message;
    public ConflictException(String _message, String _statusDescription) {
        statusCode = HttpStatus.CONFLICT;
        statusDescription = _statusDescription;
        message = _message;
    }
}
