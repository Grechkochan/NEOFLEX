package ru.vasilenko.dictionary.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Dictionary&Data microservice api",
                description = "Neoflex practice app",
                version = "1.0.0",
                contact = @Contact(
                        name = "Vasilenko Oleg",
                        email = "moris_bang@outlook.com"
                )
        )
)
public class SwaggerConfig {
}
