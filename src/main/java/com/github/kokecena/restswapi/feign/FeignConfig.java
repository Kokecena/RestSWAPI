package com.github.kokecena.restswapi.feign;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.github.kokecena.restswapi.feign")
public class FeignConfig {
}
