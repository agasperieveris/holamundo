package com.bootcamp.holamundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HolamundoController {

    @GetMapping("/hello")
    public Mono<String> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return Mono.justOrEmpty(String.format("Hello %s!", name));
    }

}
