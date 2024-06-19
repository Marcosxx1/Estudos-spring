package com.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication
 *
 * A anotação @SpringBootApplication habilita várias funcionalidades importantes no Spring Boot:
 *
 * <ul>
 *   <li>Auto configuração: {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration}</li>
 *   <li>Component Scanning: {@link org.springframework.context.annotation.ComponentScan}</li>
 *   <li>Configuração adicional: {@link org.springframework.context.annotation.Configuration}</li>
 * </ul>
 */

/*@SpringBootApplication(
		scanBasePackages = {"com.example.application", "com.example.util"} // Assim podemos fazer o scan em outros pacotes
)*/
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
