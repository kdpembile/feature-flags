package com.kentisthebest.services;


import com.launchdarkly.sdk.LDContext;

public interface LaunchDarklyService {

  boolean isFeatureFlagSet(String flag);

  boolean isFeatureFlagSet(String flag, LDContext context);


}
