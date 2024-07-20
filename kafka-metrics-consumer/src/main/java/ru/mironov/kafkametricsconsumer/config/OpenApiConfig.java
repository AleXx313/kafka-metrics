package ru.mironov.kafkametricsconsumer.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Kafka metrics consumer",
                description = "Kafka metrics consumer", version = "1.0.0",
                contact = @Contact(
                        name = "Alexey Mironov",
                        email = "alexeymironov1991@gmail.com"
                )
        )
)
public class OpenApiConfig {
}
