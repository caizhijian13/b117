package com.dhu.kgproject.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity
public class Trend extends Node {
    private String trendid;
    private String year;
    private String sex;
    public Trend(){}
}
