package com.example.application.service;

import org.springframework.stereotype.Component;

/**
 * {@code @Component} marca a classe como um bean do Spring,
 * fazendo-a uma candidata para injeção de dependência.
 */
@Component
public class TecnicoFutebol implements Tecnico {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTreino() {
        return "30 chutes ao gol";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDefesa() {
        return "10 defesas";
    }
}
