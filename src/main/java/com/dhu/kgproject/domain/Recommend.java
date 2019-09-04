package com.dhu.kgproject.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity
public class Recommend extends Node{
    public Recommend(){}
}
