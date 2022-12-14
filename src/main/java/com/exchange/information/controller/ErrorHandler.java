package com.exchange.information.controller;

import com.exchange.information.exception.ErrorResponse;
import com.exchange.information.exception.ExchangeInfoParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    private static final int DEFAULT_CODE = 10;

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleGlobalError(Exception ex) {

        return new ResponseEntity<>(new ErrorResponse(DEFAULT_CODE, "Global service malfunction"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ExchangeInfoParseException.class)
    protected ResponseEntity<Object> handleParseException(ExchangeInfoParseException ex) {

        return new ResponseEntity<>(new ErrorResponse(DEFAULT_CODE, ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
