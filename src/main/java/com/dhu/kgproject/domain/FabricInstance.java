package com.dhu.kgproject.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity(label = "fabric_instance")
public class FabricInstance extends Node{
    private String name;
    private String component;
    private String weaveMethod;
    private String company;
    private String concept;
    public FabricInstance(){}
}
