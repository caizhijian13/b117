package com.dhu.kgproject.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity
public class Fabric extends Node {
    private String fabricid;
    private String weave;
    private String figure;
    private String postprocessing;
    public Fabric(){}
}
