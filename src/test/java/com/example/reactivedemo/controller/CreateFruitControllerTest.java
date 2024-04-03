package com.example.reactivedemo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.reactivedemo.core.fruit.CreateFruit;
import com.example.reactivedemo.domain.fruit.Fruit;

import reactor.core.publisher.Mono;

class CreateFruitControllerTest {

    @Test
    void testCreateFruit() {
        CreateFruit createFruitMock = mock(CreateFruit.class);

        CreateFruitController controller = new CreateFruitController(createFruitMock);

        Fruit inputFruit = Fruit.builder()
                .name("Banana")
                .build();
        when(createFruitMock.apply(inputFruit)).thenReturn(Mono.just(inputFruit));

        WebTestClient webTestClient = WebTestClient.bindToController(controller).build();

        webTestClient.post()
                .uri("/fruit")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(inputFruit)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Fruit.class)
                .value(returnedFruit -> {
                    assertEquals(inputFruit, returnedFruit);
                });

        verify(createFruitMock, times(1)).apply(inputFruit);
    }
}
