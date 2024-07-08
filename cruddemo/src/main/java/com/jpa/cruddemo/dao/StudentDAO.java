package com.jpa.cruddemo.dao;

import com.jpa.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAllStudents();

    List<Student> findByFirstName(String theFirstName);

    void update(Student student);

    void delete(Integer id);
}