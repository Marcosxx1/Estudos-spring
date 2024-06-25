package com.jpa.cruddemo.dao;

import com.jpa.cruddemo.entity.Estudante;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
