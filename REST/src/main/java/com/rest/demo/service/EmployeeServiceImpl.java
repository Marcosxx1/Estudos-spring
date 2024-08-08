package com.rest.demo.service;

import com.rest.demo.domain.entity.Employee;
import com.rest.demo.exception.EmployeeNotFoundException;
import com.rest.demo.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException("No employees found");
        }
        return employees;
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee with id " + id + " not found"));
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        Employee existEmployee = employeeRepository.findByEmail(employee.getEmail());
        if (existEmployee != null) {
            throw new EmployeeNotFoundException("Employee with email " + employee.getEmail() + " already exist");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with email " + email + " not found");
        }
        return employee;
    }

    @Transactional
    @Override
    public void detele(int id) {
        Employee employee = findById(id);

        employeeRepository.delete(employee);
    }

    @Transactional
    @Override
    public Employee update(Employee employee) {
        Employee existEmployee = findById(employee.getId());

        existEmployee.setFirstName(employee.getFirstName());
        existEmployee.setLastName(employee.getLastName());
        return employeeRepository.save(employee);
    }


}
