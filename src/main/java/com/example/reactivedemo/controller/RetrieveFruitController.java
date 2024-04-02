package com.example.reactivedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reactivedemo.core.fruit.RetrieveFruit;
import com.example.reactivedemo.domain.fruit.Fruit;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class RetrieveFruitController {

    private final RetrieveFruit retrieveFruit;

    @GetMapping(value = "/fruit")
    public Flux<Fruit> retrieveFruit() {
        return retrieveFruit.get();
    }

}
