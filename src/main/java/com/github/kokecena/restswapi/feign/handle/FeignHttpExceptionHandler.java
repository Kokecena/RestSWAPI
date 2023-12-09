package com.github.kokecena.restswapi.feign.handle;

import feign.Response;

public interface FeignHttpExceptionHandler {
    Exception handle(Response response);
}
