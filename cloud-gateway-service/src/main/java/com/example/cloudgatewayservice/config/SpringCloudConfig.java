package com.example.cloudgatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/retrieval/**")
                        .uri("http://localhost:8080/"))
                        

                .route(r -> r.path("/callspringApp/**")
                        .uri("http://localhost:9090/"))
                  .build();
    }
}
