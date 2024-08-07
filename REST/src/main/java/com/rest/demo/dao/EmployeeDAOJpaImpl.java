package com.rest.demo.dao;

import com.rest.demo.domain.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        /*if id == 0
         * then insert/save
         * else update*/
        return entityManager.merge(employee);
    }

    @Override
    public void detele(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }

    @Override
    public Employee findByEmail(String email) {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee where email=:theEmail", Employee.class);
        query.setParameter("theEmail", email);
        try {
            return query.getSingleResult();// <--- Sem isso, temos isso: jakarta.persistence.NoResultException: No result found for query [from Employee where email=:theEmail]
        } catch (NoResultException e) {
            return null;
        }
    }

}
