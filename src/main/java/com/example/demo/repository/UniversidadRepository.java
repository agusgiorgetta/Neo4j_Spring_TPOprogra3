package com.example.demo.repository;

import com.example.demo.domain.UniversidadEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UniversidadRepository extends ReactiveNeo4jRepository<UniversidadEntity, String> {
    Mono<UniversidadEntity> findOneByName(String name);
}
