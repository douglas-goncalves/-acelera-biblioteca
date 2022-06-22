package br.com.aceleragep.api_biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ApiAceleraGepBibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAceleraGepBibliotecaApplication.class, args);
	}

}
