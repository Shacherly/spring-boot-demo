package com.duyi.config;

import com.duyi.filter.Filter1;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用此配置类代替XMl文件
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<Filter1> filterRegistrationBean() {
        FilterRegistrationBean<Filter1> filter = new FilterRegistrationBean<>();
        filter.setFilter(new Filter1());
        filter.addUrlPatterns("/*");
        // filter.setOrder(0);// 设定优先级
        return filter;
    }
}
