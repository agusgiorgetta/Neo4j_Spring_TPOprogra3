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

        // Verificar el inicio del recorrido
        System.out.println("\nIniciando BFS desde la universidad: " + inicio.getName());

        visitadoUniversidades.add(inicio);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            Object actual = cola.poll();
            System.out.println("Procesando nodo: " + actual);

            if (actual instanceof UniversidadEntity) {
                UniversidadEntity universidad = (UniversidadEntity) actual;
                resultado.append("Universidad: ").append(universidad.getName()).append("\n");

                System.out.println("Universidad encontrada: " + universidad.getName());

                for (FacultadEntity facultad : adjUniversidades.get(universidad)) {
                    System.out.println("Revisando facultades para " + universidad.getName());
                    if (!visitadoFacultades.contains(facultad)) {
                        visitadoFacultades.add(facultad);
                        cola.add(facultad);
                        System.out.println("Facultad añadida a la cola: " + facultad.getName());
                    }
                }
            } else if (actual instanceof FacultadEntity) {
                FacultadEntity facultad = (FacultadEntity) actual;
                resultado.append("Facultad: ").append(facultad.getName()).append("\n");

                System.out.println("Facultad encontrada: " + facultad.getName());

                for (CarreraEntity carrera : adjFacultades.get(facultad)) {
                    resultado.append(" -> Carrera: ").append(carrera.getName()).append("\n");
                    System.out.println("Carrera añadida a la salida: " + carrera.getName());
                }
            }
        }
        return resultado.toString();
    }

    public String DFS(UniversidadEntity inicio) {
        StringBuilder resultado = new StringBuilder();
        Set<UniversidadEntity> visitadoUniversidades = new HashSet<>();
        Set<FacultadEntity> visitadoFacultades = new HashSet<>();

        System.out.println("\nIniciando DFS desde la universidad: " + inicio.getName());

        dfsRecursivo(inicio, resultado, visitadoUniversidades, visitadoFacultades);
        return resultado.toString();
    }

    private void dfsRecursivo(Object nodo, StringBuilder resultado, Set<UniversidadEntity> visitadoUniversidades,
                              Set<FacultadEntity> visitadoFacultades) {
        System.out.println("Procesando nodo: " + nodo);

        if (nodo instanceof UniversidadEntity) {
            UniversidadEntity universidad = (UniversidadEntity) nodo;
            if (visitadoUniversidades.contains(universidad)) {
                System.out.println("Universidad ya visitada: " + universidad.getName());
                return;
            }

            visitadoUniversidades.add(universidad);
            resultado.append("Universidad: ").append(universidad.getName()).append("\n");

            System.out.println("Universidad añadida a la salida: " + universidad.getName());

            for (FacultadEntity facultad : adjUniversidades.get(universidad)) {
                System.out.println("Revisando facultades para " + universidad.getName());
                dfsRecursivo(facultad, resultado, visitadoUniversidades, visitadoFacultades);
            }
        } else if (nodo instanceof FacultadEntity) {
            FacultadEntity facultad = (FacultadEntity) nodo;
            if (visitadoFacultades.contains(facultad)) {
                System.out.println("Facultad ya visitada: " + facultad.getName());
                return;
            }

            visitadoFacultades.add(facultad);
            resultado.append("Facultad: ").append(facultad.getName()).append("\n");

            System.out.println("Facultad añadida a la salida: " + facultad.getName());

            for (CarreraEntity carrera : adjFacultades.get(facultad)) {
                resultado.append(" -> Carrera: ").append(carrera.getName()).append("\n");
                System.out.println("Carrera añadida a la salida: " + carrera.getName());
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
