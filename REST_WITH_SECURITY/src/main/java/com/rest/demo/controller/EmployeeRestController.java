package com.rest.demo.controller;

import com.rest.demo.domain.entity.Employee;
import com.rest.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/using-dao")
@RequiredArgsConstructor
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable("employeeId") int employeeId) {
        return employeeService.findById(employeeId);
    }
    @DeleteMapping("/employees/{employeeId}")
    public void deleteById(@PathVariable("employeeId") int employeeId) {
        employeeService.detele(employeeId);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }



}
