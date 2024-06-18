package com.example.application.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 'expomos'  o caminho "/"
@RestController
public class FirstRestController {

    @GetMapping("/")
    public String sayHellow() {
        return "Hello word";
    }
}