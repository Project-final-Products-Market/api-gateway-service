package com.project_final.api_gateway_service.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Rutas para User Service
                .route("user-service", r -> r
                        .path("/api/users/**")
                        .uri("lb://user-service"))

                // Rutas para Product Service
                .route("product-service", r -> r
                        .path("/api/products/**")
                        .uri("lb://product-service"))

                // Rutas para Order Service
                .route("order-service", r -> r
                        .path("/api/orders/**")
                        .uri("lb://order-service"))

                // Ruta de health check general
                .route("health-check", r -> r
                        .path("/health")
                        .uri("lb://user-service/actuator/health"))

                .build();
    }
}
