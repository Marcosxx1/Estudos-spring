package com.jpa.cruddemo.dao;

import com.jpa.cruddemo.entity.Estudante;
import jakarta.persistence.TypedQuery;

public interface EstudanteDAO {

    void save(Estudante estudante);

    Estudante findById(Integer id);
}