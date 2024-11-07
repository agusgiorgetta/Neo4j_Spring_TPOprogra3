package com.example.demo.domain;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.OUTGOING;

@Node("Facultad")
public class FacultadEntity {

    @Id
    private final String name;

    private final String location;

    @Relationship(type = "OFRECE", direction = OUTGOING)
    private Set<CarreraEntity> carreras = new HashSet<>();

    @Relationship(type = "INCLUYE", direction = Relationship.Direction.INCOMING)
    private UniversidadEntity universidadRelacionada;

    public FacultadEntity(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getlocation() {
        return location;
    }

    public Set<CarreraEntity> getCarreras() {
        return carreras;
    }

    public void setCarreras(Set<CarreraEntity> carreras) {
        this.carreras = carreras;
    }

    @Override
    public String toString() {
        return "Facultad: " + name;
    }
}

