package com.taylorsz.sceti.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmailAlreadyExistsException extends ResponseStatusException {
    public EmailAlreadyExistsException(String reason) {
        super(HttpStatus.CONFLICT, reason);
    }

}
