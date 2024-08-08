package com.rest.demo.service;

import com.rest.demo.domain.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    Employee findByEmail(String email);
    void detele(int id);

    Employee update(Employee employee);
}
