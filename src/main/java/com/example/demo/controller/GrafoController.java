package com.example.demo.controller;


import com.example.demo.domain.Grafo;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.repository.FacultadRepository;
import com.example.demo.repository.UniversidadRepository;
import com.example.demo.service.GrafoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/grafo")
public class GrafoController {

    private final GrafoService grafoservice;

    @Autowired
    public GrafoController(GrafoService serviceGrafo) {
        this.grafoservice = serviceGrafo;
    }

    @GetMapping
    public Mono<String> getGrafo() {
        return grafoservice.obtenerGrafo();
    }

    @GetMapping("/bfs")
    public Mono<String> getBFS() {
        return grafoservice.obtenerBFS();
    }

    @GetMapping("/dfs")
    public Mono<String> getDFS() {
        return grafoservice.obtenerDFS();
    }

}
