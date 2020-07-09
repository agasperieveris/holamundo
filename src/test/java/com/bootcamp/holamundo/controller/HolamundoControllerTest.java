package com.bootcamp.holamundo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(controllers = HolamundoController.class)
public class HolamundoControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void helloWorld(){
        webClient.get()
            .uri("/hello")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class)
            .isEqualTo("Hello World!");
    }

    @Test
    public void helloName(){
        webClient.get()
            .uri("/hello?name={name}","Joe")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class)
            .isEqualTo("Hello Joe!");
    }

}
