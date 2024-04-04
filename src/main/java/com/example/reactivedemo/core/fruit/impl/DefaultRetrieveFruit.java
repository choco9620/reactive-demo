package com.example.reactivedemo.core.fruit.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.reactivedemo.core.fruit.RetrieveFruit;
import com.example.reactivedemo.domain.fruit.Fruit;
import com.example.reactivedemo.repository.db.FruitRepository;
import com.example.reactivedemo.repository.domain.FruitEntity;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

/**
 * esto es un commnet
 */
@Service
@RequiredArgsConstructor
public class DefaultRetrieveFruit implements RetrieveFruit {

    // holi
    private final FruitRepository fruitRepository;

    @Override
    public Flux<Fruit> get() {
        System.out.println("hola mundo");
        List<FruitEntity> fruitList = fruitRepository.findAll();
        System.out.println(String.format("esto es una prueba de conflicto tamanio %s", fruitList.size()));

        String cadena = """
                hola mundo
                            vdsaa
                    dfghb
                """;
        return Flux.fromIterable(fruitList.stream().map(f -> Fruit.builder()
                .id(f.getId())
                .name(f.getName())
                .price(f.getPrice())
                .build()).toList());
    }

}
