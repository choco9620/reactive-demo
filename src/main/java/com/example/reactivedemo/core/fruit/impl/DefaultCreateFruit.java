package com.example.reactivedemo.core.fruit.impl;

import org.springframework.stereotype.Service;

import com.example.reactivedemo.core.fruit.CreateFruit;
import com.example.reactivedemo.domain.fruit.Fruit;
import com.example.reactivedemo.repository.db.FruitRepository;
import com.example.reactivedemo.repository.domain.FruitEntity;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultCreateFruit implements CreateFruit {

    private final FruitRepository fruitRepository;

    @Override
    public Mono<Fruit> apply(Fruit fruit) {

        FruitEntity fruitSave = fruitRepository.save(FruitEntity.builder()
                .name(fruit.getName())
                .price(fruit.getPrice())
                .build());

        return Mono.just(Fruit.builder()
                .id(fruitSave.getId())
                .name(fruitSave.getName())
                .price(fruitSave.getPrice())
                .build());
    }

}
