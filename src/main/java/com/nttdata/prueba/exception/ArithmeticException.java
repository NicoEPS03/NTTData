package com.nttdata.prueba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ArithmeticException extends Exception{
    private static final long serialVersionUIDLONG = 1L;

    public ArithmeticException(String message) {
        super(message);
    }
}
