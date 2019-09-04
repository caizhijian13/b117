package com.dhu.kgproject.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity(label = "Example")
public class Example extends Node {
    public Example(){}
    private String moulde;
}
