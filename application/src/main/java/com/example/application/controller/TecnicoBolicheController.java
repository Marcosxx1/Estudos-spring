package com.example.application.controller;

import com.example.application.service.Tecnico;
import com.example.application.service.TecnicoFutebol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TecnicoBolicheController {

    // Definir um campo privado para a dependência
    private final Tecnico tecnico;

    @Autowired
    public TecnicoBolicheController(@Qualifier("tecnicoBoliche") Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    @GetMapping("/treino-boliche")
    public String getTreino() {
        return "O treino do dia é: " + tecnico.getTreino();
    }
}
