package com.example.demo.service;

import com.example.demo.domain.Grafo;
import com.example.demo.repository.UniversidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GrafoService {

    @Autowired
    private final UniversidadRepository universidadRepository;

    @Autowired
    public GrafoService(UniversidadRepository universidadRepository) {
        this.universidadRepository = universidadRepository;
    }

    public Mono<String> obtenerGrafo() {
        return universidadRepository.findAll()
                .collectList()
                .map(universidades -> {
                    Grafo grafo = new Grafo(universidades); // Construimos el grafo con las universidades
                    return grafo.toString(); // Devolvemos la representación en String del grafo
                });
    }

    public Mono<String> obtenerBFS() {
        return universidadRepository.findAll()
                .collectList()
                .map(universidades -> {
                    Grafo grafo = new Grafo(universidades); // Construimos el grafo con las universidades
                    return grafo.BFS(universidades.get(0)); // Ejemplo de BFS
                });
    }

    public Mono<String> obtenerDFS() {
        return universidadRepository.findAll()
                .collectList()
                .map(universidades -> {
                    Grafo grafo = new Grafo(universidades); // Construimos el grafo con las universidades
                    return grafo.DFS(universidades.get(0)); // Ejemplo de DFS
                });
    }

}
