package com.jpa.cruddemo.dao;

import com.jpa.cruddemo.entity.Estudante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstudanteDAOImpl implements EstudanteDAO{

    // Definimos o campo para EntityManager
    private final EntityManager entityManager;

    // Injetamos EntityManager usando injeção por construtor
    @Autowired
    public EstudanteDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Implementa o método save
    @Override
    @Transactional
    public void save(Estudante estudante) {
        entityManager.persist(estudante);
    }

    // Implementa o método encontrar por ID
    @Override
    public Estudante findById(Integer id) {
        return entityManager.find(Estudante.class, id);
    }

    @Override
    public List<Estudante> findAllEstudantes() {
        TypedQuery<Estudante> encontraTodos = entityManager.createQuery("FROM Estudante", Estudante.class);
        return encontraTodos.getResultList();
    }

    @Override
    public  List<Estudante> findByFirstName(String theFirstName) {
        TypedQuery<Estudante> estudanteComNome = entityManager.createQuery(
                "FROM Estudante WHERE firstName=:theFirstName", Estudante.class);

        estudanteComNome.setParameter("theFirstName", theFirstName);
        return estudanteComNome.getResultList();
    }
    // Não é o nome da tabela, mas da classe
   /* TypedQuery<Estudante> nomeDaConsulta = entityManager.createQuery(
            "FROM Estudante WHERE firstName='Doe' OR firstName='anotherDoe'", Estudante.class);
    List<Estudante> estudantes = nomeDaConsulta.getResultList()*/

    /**/

}
