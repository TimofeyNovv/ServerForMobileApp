package com.example.mobileAppServer.infrastructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API for mobile app",
                version = "1.0",
                description = "documentation for backend endpoints"
        )
)
public class SwaggerConfig {}
