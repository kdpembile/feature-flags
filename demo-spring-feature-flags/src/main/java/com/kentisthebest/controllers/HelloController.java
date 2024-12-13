package com.kentisthebest.controllers;

import com.kentisthebest.services.HelloWorldService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

  private final HelloWorldService helloWorldService;

  public HelloController(HelloWorldService helloWorldService) {
    this.helloWorldService = helloWorldService;
  }

  @GetMapping(path = "/hello-world")
    public Mono<String> getMessage() {
        return helloWorldService.message("Hello World!");
    }
}
