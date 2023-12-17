package com.sava.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

        @Bean
        public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
                return builder.routes()
                                .route("users-route", r -> r.path("/api/users/**")
                                                .uri("http://localhost:8082/api/users/"))
                                .route("books-route", r -> r.path("/api/books/**")
                                                .uri("http://localhost:8081/api/books/"))
                                .route("renting-route", r -> r.path("/api/renting/**")
                                                .uri("http://localhost:8083/api/renting/"))
                                .build();
        }
}