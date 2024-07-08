package com.jpa.cruddemo.dao;

import com.jpa.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // Definimos o campo para EntityManager
    private final EntityManager entityManager;

    // Injetamos EntityManager usando injeção por construtor
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Implementa o método save
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    // Implementa o método encontrar por ID
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    // usando JPQL
    @Override
    public List<Student> findAllStudents() {
        TypedQuery<Student> encontraTodos = entityManager.createQuery("SELECT s FROM Estudante s", Student.class);
        return encontraTodos.getResultList();
    }
/*    @Override
    public List<Estudante> findAllEstudantes() {
        TypedQuery<Estudante> encontraTodos = entityManager.createQuery("FROM Estudante", Estudante.class);
        return encontraTodos.getResultList();
    }*/

    @Override
    public  List<Student> findByFirstName(String theFirstName) {
        TypedQuery<Student> estudanteComNome = entityManager.createQuery(
                "FROM Estudante WHERE firstName=:theFirstName", Student.class);

        estudanteComNome.setParameter("theFirstName", theFirstName);
        return estudanteComNome.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.getReference(Student.class, id);
        entityManager.remove(student);
    }

    // Não é o nome da tabela, mas da classe
   /* TypedQuery<Estudante> nomeDaConsulta = entityManager.createQuery(
            "FROM Estudante WHERE firstName='Doe' OR firstName='anotherDoe'", Estudante.class);
    List<Estudante> estudantes = nomeDaConsulta.getResultList()*/

    /**/

}
