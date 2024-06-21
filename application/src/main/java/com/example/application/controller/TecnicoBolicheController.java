package com.example.application.controller;

import com.example.application.service.Tecnico;
import com.example.application.service.TecnicoBoliche;
import com.example.application.service.TecnicoFutebol;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TecnicoBolicheController {

    // Definir um campo privado para a dependência
    private final TecnicoBoliche tecnico;

    @Autowired
    public TecnicoBolicheController(@Qualifier("tecnicoBoliche") TecnicoBoliche tecnico) {
        System.out.println("No controller: " + getClass().getSimpleName());
        this.tecnico = tecnico;
    }

    // Definimos nosso método init
    @PostConstruct
    public void init() {
        System.out.println("No método init(): " + getClass().getSimpleName());
    }

    // Definimos nosso método destroy
    @PreDestroy
    public void destroy() {
        System.out.println("No método destroy(): " + getClass().getSimpleName());
    }

    @GetMapping("/treino-boliche")
    public String getTreino() {
        return "O treino do dia é: " + tecnico.getTreino();
    }
}
