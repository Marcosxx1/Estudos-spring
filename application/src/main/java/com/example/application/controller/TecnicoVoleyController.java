package com.example.application.controller;

import com.example.application.service.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TecnicoVoleyController {

    private final Tecnico tecnico;

    /**
     * A injeção via construtor é preferida para dependências obrigatórias.
     * @Qualifier deixa claro para o Spring qual implementação específica deve ser injetada
     * quando há várias classes que implementam a mesma interface.
     *
     * @param tecnicoLocal a implementação específica de Tecnico a ser injetada
     */
    @Autowired
    public TecnicoVoleyController(@Qualifier("tecnicoVoley") Tecnico tecnicoLocal) {
        this.tecnico = tecnicoLocal;
    }

    /**
     * Manipula as requisições GET para "/treino-voley".
     *
     * @return uma string contendo a rotina de treino diária
     */
    @GetMapping("/treino-voley")
    public String getTreino() {
        return "O treino do dia é: " + tecnico.getTreino();
    }

    /*
    // Exemplo de injeção via setter:
    // Descomente o código abaixo se preferir a injeção via setter.
    // Ao usar @Autowired em um método setter, o Spring injetará automaticamente a dependência.

    @Autowired
    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    */
}
