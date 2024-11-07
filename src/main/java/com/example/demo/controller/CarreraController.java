package com.example.demo.controller;

import com.example.demo.domain.CarreraEntity;
import com.example.demo.repository.CarreraRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/carrera")
public class CarreraController {

    private final CarreraRepository carreraRepository;

    public CarreraController(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    @PutMapping
    Mono<CarreraEntity> createOrUpdateCarrera(@RequestBody CarreraEntity nuevaCarrera) {
        return carreraRepository.save(nuevaCarrera);
    }

    @GetMapping("/")
    Flux<CarreraEntity> getCarreras() {
        return carreraRepository.findAll();
    }

    @GetMapping("/{nombre}")
    Mono<CarreraEntity> getCarrera(@PathVariable String nombre) {
        return carreraRepository.findOneByName(nombre);
    }

}
