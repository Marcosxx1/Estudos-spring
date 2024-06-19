package com.example.application.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


// @Component indica que esta classe é um componente gerenciado pelo Spring e candidato à injeção de dependências.
// @Lazy indica que o bean só será inicializado pelo Spring no momento em que for realmente necessário, e não na inicialização do contexto da aplicação.
// podemos utilizar também spring.main.lazy-initialization=true, para setar globalmente
@Component
@Lazy
public class TecnicoBoliche implements Tecnico {
    @Override
    public String getTreino() {
        return "Jogar 10 bolas";
    }

    @Override
    public String getDefesa() {
        return "Defender 10 pinos";
    }
}
