package com.example.application.controller;

import com.example.application.service.Tecnico;
import com.example.application.service.TecnicoBoliche;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TecnicoNatacaoController {

     private final Tecnico tecnico;

    @Autowired
    public TecnicoNatacaoController
            (@Qualifier("tecnicoNatacao") Tecnico tecnico) {
        System.out.println("No controller: " + getClass().getSimpleName());
        this.tecnico = tecnico;
    }


    @GetMapping("/treino-natacao")
    public String getTreino() {
        return "O treino do dia é: " + tecnico.getTreino();
    }
}
/*git commit -m "Explaining @Component and @Bean annotations in Spring" -m "
Added configuration class SportConfig with @Bean annotation to define Tecnico bean:
- @Bean is used to explicitly declare a bean in Spring configuration.
- Returns a new instance of TecnicoNatacao for dependency injection.

Commented out @Component in TecnicoNatacao class:
- @Component indicates this class as a Spring-managed component eligible for dependency injection.
- If @Component is used, Spring automatically manages the bean lifecycle and injection.

Controller TecnicoNatacaoController uses @Autowired and @Qualifier:
- @Autowired injects TecnicoNatacao bean into the controller.
- @Qualifier(\"tecnicoNatacao\") specifies which bean to inject if multiple implementations of Tecnico exist.
- Demonstrates how Spring resolves dependencies based on annotations and configuration."
*/