package com.jpa.cruddemo;

import com.jpa.cruddemo.dao.EstudanteDAO;
import com.jpa.cruddemo.entity.Estudante;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(EstudanteDAO estudanteDao) {
		return runner -> {
			criaEstudante(estudanteDao);
		};
	}

	private void criaEstudante(EstudanteDAO estudanteDao){
			System.out.println("Criando um novo objeto estudante");
			Estudante tempEstudante = new Estudante("João", "Silva", "XXXXXXXXXXXXXXXXXXXX");

			System.out.println("Salvando o estudante...");
			estudanteDao.save(tempEstudante);


			System.out.println("Estudante salvo. Estudante id: " + tempEstudante.getId());
		}

}
