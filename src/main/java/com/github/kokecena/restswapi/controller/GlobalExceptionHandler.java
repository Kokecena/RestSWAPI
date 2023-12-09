package com.github.kokecena.restswapi.controller;

import com.github.kokecena.restswapi.exceptions.UnauthorizedException;
import com.github.kokecena.restswapi.utils.Response;
import com.github.kokecena.restswapi.utils.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Response<?>> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        String paramName = ex.getParameter().getParameterName();
        String errorMessage = "Valor invalido para el parametro: '" + paramName + "'. Por favor, provee un valor correcto.";
        return ResponseUtils.createResponse(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<Response<?>> handleUnauthorizedException(UnauthorizedException ex) {
        return ex.getResponse();
    }
}