package com.example.demo.repository;

import com.example.demo.domain.FacultadEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface FacultadRepository extends ReactiveNeo4jRepository<FacultadEntity, String> {
    Mono<FacultadEntity> findOneByName(String name);
}
