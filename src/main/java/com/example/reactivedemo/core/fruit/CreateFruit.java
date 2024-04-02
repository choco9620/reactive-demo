package com.example.reactivedemo.core.fruit;

import java.util.function.Function;

import com.example.reactivedemo.domain.fruit.Fruit;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateFruit extends Function<Fruit, Mono<Fruit>> {

}
