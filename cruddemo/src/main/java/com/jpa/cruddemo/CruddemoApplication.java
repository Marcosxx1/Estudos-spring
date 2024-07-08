package com.jpa.cruddemo;

import com.jpa.cruddemo.dao.StudentDAO;
import com.jpa.cruddemo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
        return runner -> {
           //criaEstudante(studentDao);
           //criaVariosEstudantes(studentDao);
           //encontrarEstudantePorId(studentDao);
           //encontraTodosEstudantes(studentDao);
           //encontraPorNome(studentDao, "João");

            // updateStudent(studentDao);
            //deleteStudent(studentDao);
        };
    }

    private void deleteStudent(StudentDAO studentDao) {
        int studentId = 1;
        System.out.println("Deleting student id: " + studentId);
        studentDao.delete(studentId);
        System.out.println("Done!");
    }

    private void updateStudent(StudentDAO studentDao) {

        System.out.println("Updating student...");
        Student myStudent = studentDao.findById(1);
        System.out.println("Student antes da atualização: " + myStudent);
        myStudent.setFirstName("João 2"); // trocar
        studentDao.update(myStudent);
        var myUpdatedStudent = studentDao.findById(1);
        System.out.println("Student atualizado: " + myUpdatedStudent);
        System.out.println("Done!");

    }

    private void encontrarEstudantePorId(StudentDAO studentDao) {
        Student tempStudent = studentDao.findById(1);
        System.out.println("Estudante encontrado: " + tempStudent.getFirstName());
    }

    private void criaVariosEstudantes(StudentDAO studentDao) {
        // Criando três estudantes:

        Student tempEstudante1 = new Student("João", "Silva", "XXXXXXXXXXXXXXXXXXXX");
        Student tempEstudante2 = new Student("Maria", "Silva", "XXXXXXXXXXXXXXXXXXXX");
        Student tempEstudante3 = new Student("Jose", "Silva", "XXXXXXXXXXXXXXXXXXXX");
        System.out.println("Salvando estudantes...");
        studentDao.save(tempEstudante1);
        studentDao.save(tempEstudante2);
        studentDao.save(tempEstudante3);
    }

    private void criaEstudante(StudentDAO studentDao) {
        System.out.println("Criando um novo objeto estudante");
        Student tempStudent = new Student("João", "Silva", "XXXXXXXXXXXXXXXXXXXX");

        System.out.println("Salvando o estudante...");
        studentDao.save(tempStudent);


        System.out.println("Estudante salvo. Estudante id: " + tempStudent.getId());
    }

    private void encontraTodosEstudantes(StudentDAO studentDao){
        System.out.println("Todos estudantes: ");
        List<Student> students = studentDao.findAllStudents();
        for(Student student : students){
            System.out.println(student.getFirstName());
        }
    }

    private void encontraPorNome(StudentDAO studentDAO, String nome) {
        System.out.println("Nomes parecidos: ");
        List<Student> estudantesComNomesParecidos = studentDAO.findByFirstName(nome);
        for (Student student : estudantesComNomesParecidos) {
            System.out.println(student.getFirstName());
        }
    }


}
