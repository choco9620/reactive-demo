package com.example.reactivedemo.controller;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.reactivedemo.core.fruit.RetrieveFruit;
import com.example.reactivedemo.domain.fruit.Fruit;

import reactor.core.publisher.Flux;

class RetrieveFruitControllerTest {

        @Test
        void testRetrieveFruit() {
                // Mock del servicio RetrieveFruit
                RetrieveFruit retrieveFruitMock = mock(RetrieveFruit.class);

                // Instanciar el controlador con el mock
                RetrieveFruitController controller = new RetrieveFruitController(retrieveFruitMock);

                // Configurar datos de prueba
                Fruit expectedFruit1 = Fruit.builder()
                                .name("Banana")
                                .build();
                ;
                Fruit expectedFruit2 = Fruit.builder()
                                .name("Pera")
                                .build();
                ;

                // Simular comportamiento del servicio
                when(retrieveFruitMock.get()).thenReturn(Flux.just(expectedFruit1, expectedFruit2));

                // Configurar el cliente web para realizar la solicitud HTTP al controlador
                WebTestClient webTestClient = WebTestClient.bindToController(controller).build();

                // Realizar la solicitud GET
                webTestClient.get()
                                .uri("/fruit")
                                .exchange()
                                .expectStatus().isOk()
                                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                                .expectBodyList(Fruit.class)
                                .hasSize(2)
                                .contains(expectedFruit1, expectedFruit2);

                // Verificar que el método del servicio se llamó
                verify(retrieveFruitMock, times(1)).get();
        }
}
