package com.ocano.estudiantesapi.infrastructure.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI cusomOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión Académica ")
                        .version("1.0")
                        .description("Documentación de los endpoints para alumnos y notas."));

    }

}
