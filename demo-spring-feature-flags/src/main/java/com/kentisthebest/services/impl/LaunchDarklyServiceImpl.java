package com.kentisthebest.services.impl;

import com.kentisthebest.services.LaunchDarklyService;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.server.LDClient;
import org.springframework.stereotype.Service;

@Service
public class LaunchDarklyServiceImpl implements LaunchDarklyService {

  private final LDClient ldClient;

  public LaunchDarklyServiceImpl(LDClient ldClient) {
    this.ldClient = ldClient;
  }

  @Override
  public boolean isFeatureFlagSet(String flag) {
    LDContext ldContext = LDContext.builder("app").build();
    return isFeatureFlagSet(flag, ldContext);
  }

  @Override
  public boolean isFeatureFlagSet(String flag, LDContext context) {
    return ldClient.boolVariation(flag, context, false);
  }
}
