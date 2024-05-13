package br.cnj.casosjudiciais;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableRabbit
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Casos Judiciais OpenApi", version = "1", description = "API do projeto Casos Judiciais"))
public class CasosjudiciaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasosjudiciaisApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
