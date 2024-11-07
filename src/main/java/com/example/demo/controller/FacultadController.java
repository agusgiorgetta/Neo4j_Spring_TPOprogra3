package com.example.demo.controller;

import com.example.demo.domain.FacultadEntity;
import com.example.demo.repository.FacultadRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/facultad")
public class FacultadController {

    private final FacultadRepository facultadRepository;

    public FacultadController(FacultadRepository facultadRepository) {
        this.facultadRepository = facultadRepository;
    }

    @PutMapping
    Mono<FacultadEntity> createOrUpdateFacultad(@RequestBody FacultadEntity nuevaFacultad) {
        return facultadRepository.save(nuevaFacultad);
    }

    @GetMapping("/")
    Flux<FacultadEntity> getFacultades() {
        return facultadRepository.findAll();
    }

    @GetMapping("/{nombre}")
    Mono<FacultadEntity> getFacultad(@PathVariable String nombre) {
        return facultadRepository.findOneByName(nombre);
    }

    /*
    @GetMapping("/dfs/{nombreFacultad}")
public ResponseEntity<List<Carrera>> recorrerDFS(@PathVariable String nombreFacultad) {
    return ResponseEntity.ok(facultadService.dfsRecorrido(nombreFacultad));
}
     */
}
