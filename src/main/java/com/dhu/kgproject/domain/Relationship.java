package com.dhu.kgproject.domain;


import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RelationshipEntity
public abstract class Relationship {

    @Id
    private Long id;
    private List<Relationship> relationships = new ArrayList<>();
    private double relativity;

    @StartNode
    private Node startNode;

    @EndNode
    private Node endNode;

    public Relationship() {
    }

    public void setRelativity(double relativity) {
        this.relativity = relativity;
    }

    public double getRelativity() {
        return relativity;
    }

    public Relationship(Node startNode, Node endNode) {
        this.startNode = startNode;
        this.endNode = endNode;
    }

    public Long getId() {
        return id;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }
}
