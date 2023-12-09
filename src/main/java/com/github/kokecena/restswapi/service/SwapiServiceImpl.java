package com.github.kokecena.restswapi.service;

import com.github.kokecena.restswapi.exceptions.ResponseException;
import com.github.kokecena.restswapi.exceptions.UnauthorizedException;
import com.github.kokecena.restswapi.feign.SwapiClient;
import com.github.kokecena.restswapi.model.Film;
import com.github.kokecena.restswapi.model.People;
import com.github.kokecena.restswapi.utils.Response;
import com.github.kokecena.restswapi.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SwapiServiceImpl implements SwapiService {

    private final SwapiClient swapiClient;
    private static final String AUTH_TOKEN = "equipo_jaiva";

    @Override
    public ResponseEntity<Response<?>> getCharactersFromFilm(int filmId, String token) {
        if (!isValidToken(token)) {
            throw new UnauthorizedException("Token inválido");
        }
        try {
            Film film = swapiClient.getFilmById(filmId);
            List<People> peopleList = new ArrayList<>();
            film.getCharacters().forEach(url -> peopleList.add(swapiClient.getPeopleById(extractIdFromUrl(url))));
            return ResponseUtils.createResponse(new PeopleResponse("Personajes de Star Wars que participaron en la película “"
                    .concat(film.getTitle())
                    .concat("”"), peopleList), HttpStatus.OK);
        } catch (ResponseException ex) {
            return ex.getResponse();
        }
    }

    private boolean isValidToken(String token) {
        return AUTH_TOKEN.equals(token);
    }

    private int extractIdFromUrl(String url) {
        String[] parts = url.split("/");
        return Integer.parseInt(parts[parts.length - 1]);
    }

    private record PeopleResponse(String msg, List<People> people) {
    }
}
