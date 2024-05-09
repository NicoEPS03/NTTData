package com.nttdata.prueba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IntegridadException extends Exception{

    private static final long serialVersionUIDLONG = 1L;

    public IntegridadException(String message) {
        super(message);
    }
}