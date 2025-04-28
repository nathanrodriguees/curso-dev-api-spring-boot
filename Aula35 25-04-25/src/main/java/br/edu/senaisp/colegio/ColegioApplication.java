package br.edu.senaisp.colegio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "API Rest - Colégio",
					 version = "1.0", 
					 description = "API de estudos do Senai",
					 contact = @Contact(
					 			name = "Bitt",
					 			email = "bit@bitt.com.br",
					 			url = "https://xaxa.com.br/api")))
public class ColegioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColegioApplication.class, args);
	}
}
