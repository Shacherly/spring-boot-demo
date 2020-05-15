package com.duyi.configuration.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "sf")
// @PropertySource("classpath:application.properties")
public class SfConfig {
    private String name;
    private String camp;
}
