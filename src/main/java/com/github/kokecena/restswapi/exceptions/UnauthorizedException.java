package com.github.kokecena.restswapi.exceptions;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ResponseException {

    public UnauthorizedException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.UNAUTHORIZED;
    }

}
