package com.duyi.configuration.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "ng")
public class NagaConfig {
    private String heroName;
    private String campName;
    private String[] position;
}
