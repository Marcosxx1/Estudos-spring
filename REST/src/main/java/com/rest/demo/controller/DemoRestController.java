package com.rest.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/test")
public class DemoRestController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    // Entrada - Jackson utiliza os setters das classes para fazer data binding/marshaling/serialization
    // Saída   - Quando estamos construíndo aplicações REST, SPRING irá lidar automaticamente com a integração
    // com Jackson. Data em formato JSON quando passa por um controller REST é convertida para um POJO
    // Um objeto java sendo retornado de um controllador REST é convertido para JSON
}
