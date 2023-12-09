package com.github.kokecena.restswapi.exceptions;

import org.springframework.http.HttpStatus;

public class FilmNotFoundException extends ResponseException {
    public FilmNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
