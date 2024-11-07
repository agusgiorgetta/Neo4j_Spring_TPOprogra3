package com.example.demo.domain;


import java.util.*;
import java.util.Set;

public class Grafo {

    private Map<UniversidadEntity, List<FacultadEntity>> adjUniversidades;
    private Map<FacultadEntity, List<CarreraEntity>> adjFacultades;

    public Grafo(List<UniversidadEntity> universidades) {
        adjUniversidades = new HashMap<>();
        adjFacultades = new HashMap<>();

        for (UniversidadEntity universidad : universidades) {
            adjUniversidades.putIfAbsent(universidad, new ArrayList<>(universidad.getFacultades()));

            for (FacultadEntity facultad : universidad.getFacultades()) {
                adjFacultades.putIfAbsent(facultad, new ArrayList<>(facultad.getCarreras()));
            }
        }
    }


    public String BFS(UniversidadEntity inicio) {
        StringBuilder resultado = new StringBuilder();
        Set<UniversidadEntity> visitadoUniversidades = new HashSet<>();
        Set<FacultadEntity> visitadoFacultades = new HashSet<>();
        Queue<Object> cola = new LinkedList<>();

        visitadoUniversidades.add(inicio);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            Object actual = cola.poll();
            if (actual instanceof UniversidadEntity) {
                UniversidadEntity universidad = (UniversidadEntity) actual;
                resultado.append("Universidad: ").append(universidad.getName()).append("\n");

                for (FacultadEntity facultad : adjUniversidades.get(universidad)) {
                    if (!visitadoFacultades.contains(facultad)) {
                        visitadoFacultades.add(facultad);
                        cola.add(facultad);
                    }
                }
            } else if (actual instanceof FacultadEntity) {
                FacultadEntity facultad = (FacultadEntity) actual;
                resultado.append("Facultad: ").append(facultad.getName()).append("\n");

                for (CarreraEntity carrera : adjFacultades.get(facultad)) {
                    resultado.append(" -> Carrera: ").append(carrera.getName()).append("\n");
                }
            }
        }
        return resultado.toString();
    }

    public String DFS(UniversidadEntity inicio) {
        StringBuilder resultado = new StringBuilder();
        Set<UniversidadEntity> visitadoUniversidades = new HashSet<>();
        Set<FacultadEntity> visitadoFacultades = new HashSet<>();

        dfsRecursivo(inicio, resultado, visitadoUniversidades, visitadoFacultades);
        return resultado.toString();
    }

    private void dfsRecursivo(Object nodo, StringBuilder resultado, Set<UniversidadEntity> visitadoUniversidades,
                              Set<FacultadEntity> visitadoFacultades) {
        if (nodo instanceof UniversidadEntity) {
            UniversidadEntity universidad = (UniversidadEntity) nodo;
            if (visitadoUniversidades.contains(universidad)) return;

            visitadoUniversidades.add(universidad);
            resultado.append("Universidad: ").append(universidad.getName()).append("\n");

            for (FacultadEntity facultad : adjUniversidades.get(universidad)) {
                dfsRecursivo(facultad, resultado, visitadoUniversidades, visitadoFacultades);
            }
        } else if (nodo instanceof FacultadEntity) {
            FacultadEntity facultad = (FacultadEntity) nodo;
            if (visitadoFacultades.contains(facultad)) return;

            visitadoFacultades.add(facultad);
            resultado.append("Facultad: ").append(facultad.getName()).append("\n");

            for (CarreraEntity carrera : adjFacultades.get(facultad)) {
                resultado.append(" -> Carrera: ").append(carrera.getName()).append("\n");
            }
        }
    }

    @Override
    public String toString() {
        return "Grafo {" +
                "adjFacultades = " + adjFacultades +
                ", adjUniversidades=" + adjUniversidades +
                '}';
    }

}
