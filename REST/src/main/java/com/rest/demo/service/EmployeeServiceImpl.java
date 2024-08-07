package com.rest.demo.service;

import com.rest.demo.dao.EmployeeDAO;
import com.rest.demo.domain.entity.Employee;
import com.rest.demo.exception.EmployeeNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException("No employees found");
        }
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = employeeDAO.findById(id);

        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        return employee;
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        Employee existEmployee = employeeDAO.findByEmail(employee.getEmail());
        if (existEmployee != null) {
            throw new EmployeeNotFoundException("Employee with email " + employee.getEmail() + " already exist");
        }
        return employeeDAO.save(employee);
    }

    @Override
    public Employee findByEmail(String email) {
        Employee employee = employeeDAO.findByEmail(email);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with email " + email + " not found");
        }
        return employee;
    }

    @Transactional
    @Override
    public void detele(int id) {
        Employee employee = employeeDAO.findById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        employeeDAO.detele(id);
    }

    @Transactional
    @Override
    public Employee update( Employee employee) {
        Employee existEmployee = employeeDAO.findById(employee.getId());
        if (existEmployee == null) {
            throw new EmployeeNotFoundException("Employee with id " + employee.getId() + " not found");
        }
        existEmployee.setFirstName(employee.getFirstName());
        existEmployee.setLastName(employee.getLastName());
       return employeeDAO.save(employee);
    }


}
