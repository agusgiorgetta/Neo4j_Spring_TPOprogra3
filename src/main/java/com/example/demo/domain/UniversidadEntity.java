package com.example.demo.domain;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.OUTGOING;

@Node("Universidad")
public class UniversidadEntity {

    @Id
    private final String name;
    private final String location;

    @Relationship(type = "INCLUYE", direction = OUTGOING)
    private Set<FacultadEntity> facultades = new HashSet<>();

    public UniversidadEntity(String location, String name) {
        this.location = location;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Set<FacultadEntity> getFacultades() {
        return facultades;
    }

    public void setFacultades(Set<FacultadEntity> facultades) {
        this.facultades = facultades;
    }

    @Override
    public String toString() {
        return "Universidad: " + name;
    }

}
