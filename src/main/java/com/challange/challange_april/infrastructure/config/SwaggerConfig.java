package com.challange.challange_april.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI personalized(){
        return new OpenAPI()
                .info(new Info()
                        .title("Api de registro de usuarios")
                        .version("1.0")
                        .description("Documentación del microservicio 'Registro de usuarios'"));
    }

}
