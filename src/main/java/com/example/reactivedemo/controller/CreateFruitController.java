package com.example.reactivedemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.reactivedemo.core.fruit.CreateFruit;
import com.example.reactivedemo.domain.fruit.Fruit;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class CreateFruitController {

    private final CreateFruit createFruit;

    @PostMapping(value = "/fruit")
    public Mono<Fruit> createFruit(@RequestBody Fruit fruit) {
        return createFruit.apply(fruit);
    }

}
