package com.example.demo.controller;

import com.example.demo.domain.FacultadEntity;
import com.example.demo.domain.UniversidadEntity;
import com.example.demo.repository.UniversidadRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/universidad")
public class UniversidadController {

    private final UniversidadRepository universidadRepository;

    public UniversidadController(UniversidadRepository universidadRepository) {
        this.universidadRepository = universidadRepository;
    }

    @PutMapping
    Mono<UniversidadEntity> createOrUpdateUniversidad(@RequestBody UniversidadEntity nuevaUniversidad) {
        return universidadRepository.save(nuevaUniversidad);
    }

    @GetMapping("/")
    Flux<UniversidadEntity> getUniversidades() {
        return universidadRepository.findAll();
    }

    @GetMapping("/{nombre}")
    Mono<UniversidadEntity> getUniversidad(@PathVariable String nombre) {
        return universidadRepository.findOneByName(nombre);
    }

}
