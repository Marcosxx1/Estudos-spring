package com.example.application.service;

/**
 * Interface que define os métodos para os técnicos.
 */
public interface Tecnico {

    /**
     * Retorna a rotina de treino do técnico.
     *
     * @return uma string com a rotina de treino
     */
    public String getTreino();

    /**
     * Retorna a rotina de defesa do técnico.
     *
     * @return uma string com a rotina de defesa
     */
    public String getDefesa();
}
