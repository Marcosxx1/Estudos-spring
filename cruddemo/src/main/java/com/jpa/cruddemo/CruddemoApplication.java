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
            criaVariosEstudantes(estudanteDao);
            encontrarEstudantePorId(estudanteDao);
        };
    }

    private void encontrarEstudantePorId(EstudanteDAO estudanteDao) {
        Estudante tempEstudante = estudanteDao.findById(1);
        System.out.println("Estudante encontrado: " +tempEstudante.getFirstName());
    }

    private void criaVariosEstudantes(EstudanteDAO estudanteDao) {
        // Criando três estudantes:

        Estudante tempEstudante1 = new Estudante("João", "Silva", "XXXXXXXXXXXXXXXXXXXX");
        Estudante tempEstudante2 = new Estudante("Maria", "Silva", "XXXXXXXXXXXXXXXXXXXX");
        Estudante tempEstudante3 = new Estudante("Jose", "Silva", "XXXXXXXXXXXXXXXXXXXX");
        System.out.println("Salvando estudantes...");
        estudanteDao.save(tempEstudante1);
        estudanteDao.save(tempEstudante2);
        estudanteDao.save(tempEstudante3);
    }

    private void criaEstudante(EstudanteDAO estudanteDao) {
        System.out.println("Criando um novo objeto estudante");
        Estudante tempEstudante = new Estudante("João", "Silva", "XXXXXXXXXXXXXXXXXXXX");

        System.out.println("Salvando o estudante...");
        estudanteDao.save(tempEstudante);


        System.out.println("Estudante salvo. Estudante id: " + tempEstudante.getId());
    }

}
