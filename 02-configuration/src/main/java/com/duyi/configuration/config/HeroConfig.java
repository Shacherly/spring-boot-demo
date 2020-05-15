package com.duyi.configuration.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// 声明这是一个配置类，在Spring中可以替代xml文件
@Configuration
// 声明这是一个配置类，并声明前缀
@ConfigurationProperties(prefix = "base")
// 声明这是一个配置类，指向对应的配置文件地址
// @PropertySource("classpath:application.properties")
@Data
public class HeroConfig {
    // 要创建对应的数据类型来接收这些属性，与配置类字段相同。
    private String attribute;
    private String support;
    private String magic;
    private String hero;
}
