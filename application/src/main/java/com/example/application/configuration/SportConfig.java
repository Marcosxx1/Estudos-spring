package com.example.application.configuration;

import com.example.application.service.Tecnico;
import com.example.application.service.TecnicoNatacao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Tecnico tecnicoNatacao() {
        return new TecnicoNatacao();
    }
}
