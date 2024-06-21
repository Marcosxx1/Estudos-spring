package com.example.application.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


// @Component indica que esta classe é um componente gerenciado pelo Spring e candidato à injeção de dependências.
// Caso não utilizemos @Component, e estejamos utilizando @Qualifier, teremos o seguinte erro:
/*Parameter 0 of constructor in com.example.application.controller.TecnicoNatacaoController required a bean of type 'com.example.application.service.Tecnico' that could not be found.

The injection point has the following annotations:
	- @org.springframework.beans.factory.annotation.Qualifier("tecnicoNatacao")*/
//@Component
 public class TecnicoNatacao implements Tecnico {

    public TecnicoNatacao() {
        System.out.println("TecnicoNatacao: "+ getClass().getSimpleName());
    }

    @Override
    public String getTreino() {
        return "Nadar 100 metros";
    }

    @Override
    public String getDefesa() {
        return "Nadar rápido";
    }
}

