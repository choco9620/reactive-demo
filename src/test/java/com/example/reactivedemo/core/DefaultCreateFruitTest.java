package com.example.reactivedemo.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.example.reactivedemo.core.fruit.impl.DefaultCreateFruit;
import com.example.reactivedemo.domain.fruit.Fruit;
import com.example.reactivedemo.repository.db.FruitRepository;
import com.example.reactivedemo.repository.domain.FruitEntity;

import reactor.core.publisher.Mono;

class DefaultCreateFruitTest {

    @Test
    void testApply() {
        FruitRepository fruitRepositoryMock = mock(FruitRepository.class);

        Fruit fruit = Fruit.builder().build();

        FruitEntity fruitEntityAfterSave = FruitEntity.builder().build();

        when(fruitRepositoryMock.save(any(FruitEntity.class))).thenReturn(fruitEntityAfterSave);

        DefaultCreateFruit createFruitService = new DefaultCreateFruit(fruitRepositoryMock);

        Mono<Fruit> result = createFruitService.apply(fruit);

        Fruit savedFruit = result.block();
        assertNotNull(savedFruit);

        verify(fruitRepositoryMock, times(1)).save(any(FruitEntity.class));
    }
}
