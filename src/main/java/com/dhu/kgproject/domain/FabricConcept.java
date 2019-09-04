package com.dhu.kgproject.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity(label = "fabric_concept")
public class FabricConcept extends Node{
    private String name;
    public FabricConcept(){}
}
