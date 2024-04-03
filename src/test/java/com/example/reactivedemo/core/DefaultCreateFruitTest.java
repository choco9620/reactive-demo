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

public class DefaultCreateFruitTest {

    @Test
    public void testApply() {
        // Crear un mock del repositorio FruitRepository
        FruitRepository fruitRepositoryMock = mock(FruitRepository.class);

        // Crear una instancia de fruta de prueba
        Fruit fruit = Fruit.builder().build();

        // Crear una instancia de fruta de entidad esperada después de guardar
        FruitEntity fruitEntityAfterSave = FruitEntity.builder().build();

        // Simular el comportamiento del repositorio
        when(fruitRepositoryMock.save(any(FruitEntity.class))).thenReturn(fruitEntityAfterSave);

        // Instanciar el servicio DefaultCreateFruit con el mock del repositorio
        DefaultCreateFruit createFruitService = new DefaultCreateFruit(fruitRepositoryMock);

        // Llamar al método apply del servicio
        Mono<Fruit> result = createFruitService.apply(fruit);

        // Verificar que el resultado es correcto
        Fruit savedFruit = result.block();
        assertNotNull(savedFruit);
        // Verificar los detalles de la fruta guardada si es necesario

        // Verificar que se llamó al método save del repositorio con la fruta correcta
        verify(fruitRepositoryMock, times(1)).save(any(FruitEntity.class));
    }
}
