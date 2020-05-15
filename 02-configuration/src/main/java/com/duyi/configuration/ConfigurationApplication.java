package com.duyi.configuration;

import com.duyi.configuration.config.NagaConfig;
import com.duyi.configuration.config.SfConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication/*@ComponentScan,@EnableAutoConfiguration,@SpringBootConfiguration*/
// 告知主程序入口自动引入配置文件
// @EnableConfigurationProperties({NagaConfig.class, SfConfig.class})
public class ConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationApplication.class, args);
    }

}
