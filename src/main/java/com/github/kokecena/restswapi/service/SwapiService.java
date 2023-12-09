package com.github.kokecena.restswapi.service;

import com.github.kokecena.restswapi.utils.Response;
import org.springframework.http.ResponseEntity;


public interface SwapiService {
    ResponseEntity<Response<?>> getCharactersFromFilm(int filmId, String token);
}
