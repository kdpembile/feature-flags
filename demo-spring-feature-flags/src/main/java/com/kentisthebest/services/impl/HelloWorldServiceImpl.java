package com.kentisthebest.services.impl;

import com.kentisthebest.services.HelloWorldService;
import com.kentisthebest.services.LaunchDarklyService;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

  private final LaunchDarklyService launchDarklyService;

  @Value("${launch-darkly.flag-upper-case}")
  private String flagUpperCase;

  public HelloWorldServiceImpl(LaunchDarklyService launchDarklyService) {
    this.launchDarklyService = launchDarklyService;
  }

  @Override
  public Mono<String> message(String message) {
    if (launchDarklyService.isFeatureFlagSet(flagUpperCase)) {
      return Mono.just(message.toUpperCase(Locale.ROOT));
    }

    return Mono.just(message);
  }
}
