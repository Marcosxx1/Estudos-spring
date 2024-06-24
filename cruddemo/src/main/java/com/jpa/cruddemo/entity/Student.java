package com.jpa.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    /*Podemos também criar um identificador de ID diferente de todos os disponíveis do JPA*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;
}
