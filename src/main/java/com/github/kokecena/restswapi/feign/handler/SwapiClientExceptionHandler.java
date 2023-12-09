package com.github.kokecena.restswapi.feign.handler;

import com.github.kokecena.restswapi.exceptions.FilmNotFoundException;
import com.github.kokecena.restswapi.exceptions.InternalServerException;
import com.github.kokecena.restswapi.exceptions.UnauthorizedException;
import com.github.kokecena.restswapi.feign.handle.FeignHttpExceptionHandler;
import com.github.kokecena.restswapi.utils.FeignUtils;
import feign.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class SwapiClientExceptionHandler implements FeignHttpExceptionHandler {
    @Override
    public Exception handle(Response response) {
        HttpStatus httpStatus = HttpStatus.resolve(response.status());
        String body = FeignUtils.readBody(response.body());
        if (HttpStatus.NOT_FOUND.equals(httpStatus)) {
            return new FilmNotFoundException("No se encontro el filme especificado en la base de datos.");
        }
        if (HttpStatus.UNAUTHORIZED.equals(httpStatus)){
            return new UnauthorizedException("Token no valido.");
        }
        return new InternalServerException(body);
    }
}
