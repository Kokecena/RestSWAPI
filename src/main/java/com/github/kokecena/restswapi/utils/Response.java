package com.github.kokecena.restswapi.utils;

public record Response<T>(Integer code, T message) {}
