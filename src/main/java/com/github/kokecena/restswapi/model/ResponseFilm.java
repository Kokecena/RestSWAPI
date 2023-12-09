package com.github.kokecena.restswapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseFilm {
    private Integer count;
    private String next;
    private String previous;
    private List<Film> results;
}
