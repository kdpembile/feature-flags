package com.kentisthebest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

    @GetMapping(path = "/hello-world")
    public Mono<String> getMessage() {
        return Mono.just("Hello World");
    }
}
