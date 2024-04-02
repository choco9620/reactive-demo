package com.example.reactivedemo.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reactivedemo.repository.domain.FruitEntity;

public interface FruitRepository extends JpaRepository<FruitEntity, Long> {

}
