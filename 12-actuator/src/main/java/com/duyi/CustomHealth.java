package com.duyi;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class CustomHealth implements HealthIndicator {
    @Override
    public Health health() {
        return null;
    }
}
