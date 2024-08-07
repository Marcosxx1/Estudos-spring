package com.rest.demo.controller;

import com.rest.demo.entity.Employee;
import com.rest.demo.exception.EmployeeNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees;

    @PostConstruct
    public void loadData() {
        employees = new ArrayList<>();
        employees.add(new Employee(0, "Mario", "Dey", "Mario.Dey@example.com"));
        employees.add(new Employee(1, "John", "Doe", "john.doe@example.com"));
        employees.add(new Employee(2, "Jane", "Smith", "jane.smith@example.com"));
        employees.add(new Employee(3, "Michael", "Johnson", "michael.johnson@example.com"));
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        var nextIndex = employees.size() + 1;
        employee.setId(nextIndex);
        employees.add(employee);
        return employee;
    }

    @GetMapping
    public List<Employee> listEmployees() {
        return employees;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        if (id <= 0 || id > employees.size()) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }

        employee.setId(id);

        employees.set(id - 1, employee);

        return employee;
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        if (id <= 0 || id > employees.size()) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }

        return employees.get(id - 1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
        if (id <= 0 || id > employees.size()) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }

        employees.remove(id - 1);

        return ResponseEntity.noContent().build();
    }

}