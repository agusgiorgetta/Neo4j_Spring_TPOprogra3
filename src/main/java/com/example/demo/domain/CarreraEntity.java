package com.example.demo.domain;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Carrera")
public class CarreraEntity {
    @Id
    private final Integer id;
    private final String name;

    @Relationship(type = "OFRECE", direction = Relationship.Direction.INCOMING)
    private FacultadEntity facultadRelacionada;

    public CarreraEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Carrera: " + name;
    }
}
