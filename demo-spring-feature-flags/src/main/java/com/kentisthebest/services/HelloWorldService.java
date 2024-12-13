package com.kentisthebest.services;

import reactor.core.publisher.Mono;

public interface HelloWorldService {

  Mono<String> message(String message);
}
