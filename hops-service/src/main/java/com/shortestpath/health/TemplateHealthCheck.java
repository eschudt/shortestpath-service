package com.shortestpath.health;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck{

	private final long defaultHops;

    public TemplateHealthCheck(long defaultHops) {
        this.defaultHops = defaultHops;
    }

    @Override
    protected Result check() throws Exception {
        if (defaultHops < 0) {
            return Result.unhealthy("defaultHops has invalid value");
        }
        return Result.healthy();
    }
}
