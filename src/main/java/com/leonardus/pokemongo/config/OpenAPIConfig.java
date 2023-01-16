package com.leonardus.pokemongo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    OpenAPI openAPI(){
        return new OpenAPI().info(new Info().title("Pokémon GO").version("1.0.0")
                .description("This API allows you to dynamically query a database with all 822 pokémons in the game."));
    }
}
