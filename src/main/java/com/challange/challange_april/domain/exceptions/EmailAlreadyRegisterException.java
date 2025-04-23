package com.challange.challange_april.domain.exceptions;

public class EmailAlreadyRegisterException extends RuntimeException {
    public EmailAlreadyRegisterException(String message) {
        super(message);
    }
}
