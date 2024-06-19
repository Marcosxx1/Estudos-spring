package com.example.application.controller;

import com.example.application.service.Tecnico;
import com.example.application.service.TecnicoFutebol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TecnicoFutebolController {

    // Definir um campo privado para a dependência
    private final TecnicoFutebol tecnico;

    /**
     * Construtor para injeção de dependência.
     * Quando temos apenas um construtor, @Autowired não é necessário, mas é usado aqui para fins didáticos.
     *
     * @param tecnico a implementação específica de TecnicoFutebol a ser injetada
     */
    @Autowired
    public TecnicoFutebolController(TecnicoFutebol tecnico) {
        this.tecnico = tecnico;
    }

    /**
     * Manipula as requisições GET para "/treino".
     *
     * @return uma string contendo a rotina de treino diária
     */
    @GetMapping("/treino")
    public String getTreino() {
        return "O treino do dia é: " + tecnico.getTreino();
    }
}
