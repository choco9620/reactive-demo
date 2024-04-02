package com.example.reactivedemo.core.fruit;

import java.util.function.Supplier;

import com.example.reactivedemo.domain.fruit.Fruit;

import reactor.core.publisher.Flux;

@FunctionalInterface
public interface RetrieveFruit extends Supplier<Flux<Fruit>> {

}
