package com.duyi;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class WebContainerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebContainerApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> hello() {
        return route(
                GET("/hello"),
                serverRequest -> ok().body(
                        Mono.just("Hello Reactive"), String.class
                )
        );
    }

    // 当使用WebServer容器启动时查看具体的容器类
    // 响应式容器无法使用此方法，但是另有其他方法
    @Bean
    public ApplicationRunner runner(WebServerApplicationContext context) {
        return args -> System.out.println("当前的容器实现类：" +
                context.getWebServer().getClass().getName());
    }
}
