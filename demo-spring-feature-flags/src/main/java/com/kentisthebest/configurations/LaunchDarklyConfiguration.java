package com.kentisthebest.configurations;


import com.launchdarkly.sdk.server.LDClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaunchDarklyConfiguration {

  @Bean
  public LDClient launchDarklyClient(@Value("${launch-darkly.sdk-key}") String key) {
    return new LDClient(key);

  }
}
