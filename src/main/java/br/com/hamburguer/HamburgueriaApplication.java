package br.com.hamburguer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API - Boas Práticas De Programação ",
				version = "1.0",
				description = "API para exercitar boas práticas para um codigo limpo e fácil manutenção.",
				contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
)
public class HamburgueriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HamburgueriaApplication.class, args);
	}

}
