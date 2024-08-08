package com.rest.demo.repository;

import com.rest.demo.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e " +
            "FROM Employee e " +
            "WHERE e.email = :email")
    Employee findByEmail(String email);
}
