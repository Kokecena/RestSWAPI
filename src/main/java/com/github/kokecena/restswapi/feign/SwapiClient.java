package com.github.kokecena.restswapi.feign;

import com.github.kokecena.restswapi.exceptions.FilmNotFoundException;
import com.github.kokecena.restswapi.exceptions.InternalServerException;
import com.github.kokecena.restswapi.feign.handle.HandleFeignError;
import com.github.kokecena.restswapi.feign.handler.SwapiClientExceptionHandler;
import com.github.kokecena.restswapi.model.Film;
import com.github.kokecena.restswapi.model.People;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "swapi", url = "https://swapi.dev/api/")
public interface SwapiClient {
    @GetMapping(value = "films/{film_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @HandleFeignError(SwapiClientExceptionHandler.class)
    Film getFilmById(@PathVariable("film_id") int filmId) throws FilmNotFoundException, InternalServerException;

    @GetMapping(value = "people/{id}")
    People getPeopleById(@PathVariable("id") int id);
}
