package com.dhu.kgproject.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity(label = "company")
public class Company extends Node{
    private String name;
    private String address;
    private String tel;
    private String detail;
}
