package com.rest.demo.dao;

import com.rest.demo.domain.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    Employee findById(int id);
    Employee save(Employee employee);
    void detele(int id);

    Employee findByEmail(String email);
}

