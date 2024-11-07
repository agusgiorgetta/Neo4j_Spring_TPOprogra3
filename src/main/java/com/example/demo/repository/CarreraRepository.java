package com.example.demo.repository;

import com.example.demo.domain.CarreraEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CarreraRepository extends ReactiveNeo4jRepository<CarreraEntity, Integer> {
    Mono<CarreraEntity> findOneByName(String name);
}