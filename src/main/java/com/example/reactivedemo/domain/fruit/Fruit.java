package com.example.reactivedemo.domain.fruit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Fruit {

    private Long id;
    private String name;
    private Long price;

}
