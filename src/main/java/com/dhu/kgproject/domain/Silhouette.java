package com.dhu.kgproject.domain;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Silhouette extends Node {
    private String silhouetteid;
    private String cate;
    public Silhouette(){}
}
