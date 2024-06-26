package com.jpa.cruddemo.dao;

import com.jpa.cruddemo.entity.Estudante;
import jakarta.persistence.TypedQuery;

import java.util.List;

public interface EstudanteDAO {

    void save(Estudante estudante);

    Estudante findById(Integer id);

    List<Estudante> findAllEstudantes();

    List<Estudante> findByFirstName(String theLastName);
}