package com.hiringcoders.core.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI hiringCoinsOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Hiring Coins API")
						.description("API Hiring Coins Desafio Semifinal Hiring Coders #3 - Grupo Controll 03")
						.contact(new Contact()
								.name("Douglas Rodrigues")
								.email("wandersondouglasr@gmail.com"))
						.version("v1.0.0"));
	}

}
