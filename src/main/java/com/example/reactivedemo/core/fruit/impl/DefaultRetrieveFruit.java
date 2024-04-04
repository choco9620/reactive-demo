package com.example.reactivedemo.core.fruit.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.reactivedemo.core.fruit.RetrieveFruit;
import com.example.reactivedemo.domain.fruit.Fruit;
import com.example.reactivedemo.repository.db.FruitRepository;
import com.example.reactivedemo.repository.domain.FruitEntity;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveFruit implements RetrieveFruit {

    private final FruitRepository fruitRepository;

    '''
    Lorem Ipsum es simplemente el texto de relleno de las imprentas y 
    archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar 
    de las industrias desde el año 1500, cuando un impresor 
    (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos
     y los mezcló de tal manera que logró hacer un libro de textos especimen. 
     No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno 
     en documentos electrónicos, quedando esencialmente igual al original. 
     Fue popularizado en los 60s con la creación de las hojas "Letraset", las cuales contenian 
     pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo 
     ldus PageMaker, el cual incluye versiones de Lorem Ipsum.
    '''

    @Override
    public Flux<Fruit> get() {

        System.out.println("Conflicto1");
        List<FruitEntity> fruitList = fruitRepository.findAll();
        System.out.println("Conflicto2");

        return Flux.fromIterable(fruitList.stream().map(f -> Fruit.builder()
                .id(f.getId())
                .name(f.getName())
                .price(f.getPrice())
                .build()).toList());
                System.out.println("Conflicto3");
    }
    System.out.println("Conflicto");

}
