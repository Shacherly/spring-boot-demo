package com.duyi.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> customizer() {
        return factory -> factory.setPort(8899);
    }
}
