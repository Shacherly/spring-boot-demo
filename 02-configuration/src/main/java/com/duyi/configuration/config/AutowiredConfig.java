package com.duyi.configuration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowiredConfig {

    @Bean("test")
    public HeroConfig getHeroConfig(HeroConfig heroConfig) {
        return heroConfig;
    }
}
