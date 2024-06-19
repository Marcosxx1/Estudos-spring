package com.example.application.service;

import org.springframework.stereotype.Component;

/*@Component marca a classe como um bean do spring
* Fazendo-a uma candidata para injeção de dependencia*/
@Component
public class TecnicoVoley implements Tecnico{
    @Override
    public String getTreino() {
        return "30 chutes ao gol";
    }
    
    @Override
    public String getDefesa() {
        return "10 defesas";
    }


}
