package com.example.reactivedemo.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.reactivedemo.core.fruit.impl.DefaultRetrieveFruit;
import com.example.reactivedemo.domain.fruit.Fruit;
import com.example.reactivedemo.repository.db.FruitRepository;
import com.example.reactivedemo.repository.domain.FruitEntity;

import reactor.core.publisher.Flux;

public class DefaultRetrieveFruitTest {

    @Test
    public void testGet() {
        FruitRepository fruitRepositoryMock = mock(FruitRepository.class);

        FruitEntity fruitEntity1 = FruitEntity.builder()
                .id(1L)
                .name("Banana")
                .build();
        FruitEntity fruitEntity2 = FruitEntity.builder()
                .id(2L)
                .name("Pera")
                .build();
        ;

        List<FruitEntity> fruitEntityList = Arrays.asList(fruitEntity1, fruitEntity2);

        when(fruitRepositoryMock.findAll()).thenReturn(fruitEntityList);

        DefaultRetrieveFruit retrieveFruitService = new DefaultRetrieveFruit(fruitRepositoryMock);

        Flux<Fruit> result = retrieveFruitService.get();

        List<Fruit> fruitList = result.collectList().block();
        assertNotNull(fruitList);

        assertEquals(2, fruitList.size());

        verify(fruitRepositoryMock, times(1)).findAll();
    }
}
