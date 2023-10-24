package br.com.generationbrasil.studentsgen;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Students Gen Swagger", version = "1",
		description = "API RESTful para cadastro de alunos e suas notas semestrais"))
public class StudentsgenApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsgenApplication.class, args);
	}

}
