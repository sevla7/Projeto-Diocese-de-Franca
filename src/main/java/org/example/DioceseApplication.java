package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação.
 * Responsável por iniciar o servidor embutido (Tomcat) e carregar os controladores REST.
 */
@SpringBootApplication
public class DioceseApplication {
    public static void main(String[] args) {
        SpringApplication.run(DioceseApplication.class, args);
        System.out.println("✅ Servidor iniciado em http://localhost:8080");
    }
}
