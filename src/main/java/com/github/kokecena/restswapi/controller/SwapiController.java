package com.github.kokecena.restswapi.controller;

import com.github.kokecena.restswapi.service.SwapiService;
import com.github.kokecena.restswapi.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/swapi/")
@RequiredArgsConstructor
public class SwapiController {
    private final SwapiService service;

    @PostMapping("film/{id}")
    public ResponseEntity<Response<?>> getFilms(@PathVariable int id, @RequestHeader("Authorization") String token) {
        return service.getCharactersFromFilm(id, token);
    }
}
