package com.dhu.kgproject.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;

@Data
@NodeEntity
public class Node {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
//    private String level;
    private String description;
    private String type;
    private String url;
    private String image;
    private String feature;
    private String star;
    private String shortcoming;
    private String otherName;
    private Double size;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "Include")
    private List<Relationship> LowerInclude;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "INCLUDE")
    private List<Relationship> UpperInclude;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "DesignTrend")
    private List<Relationship> DesignTrend;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "TrendFabric")
    private List<Relationship> TrendFabric;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "FabricDesign")
    private List<Relationship> FabricDesign;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "Attribute_of")
    private List<Relationship> Attribute_of;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "Instance_of")
    private List<Relationship> Instance_of;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "Part_of")
    private List<Relationship> Part_of;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "Kind_of")
    private List<Relationship> Kind_of;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "kind_of")
    private List<Relationship> LowerKind_of;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "instance_of")
    private List<Relationship> LowerInstance_of;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "NEXT")
    private List<Relationship> Next;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "suit_for")
    private List<Relationship> fit;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "unsuit_for")
    private List<Unfit> Unfit;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "匹配")
    private List<Match> Match;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "rel")
    private List<Rel> rel;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "company_of")
    private List<company_of> company_ofs;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "fabric_trend")
    private List<fabric_trend> fabric_trends;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "color_trend")
    private List<Relationship> color_trends;

    public Node() {
    }

    public Node(Long id, String name, String description, String type,String img_url,String url) {
        this.id = id;
        this.name = name;
//        this.level = level;
        this.description = description;
        this.type = type;
        this.url = url;
        this.image = img_url;
    }
    public String getMyClass(){
         return this.getClass().getName().replaceAll(".*\\.","");
    }
//    public Node(Long id, String name, String level, String description, String type, String img_url) {
//        this.id = id;
//        this.name = name;
//        this.level = level;
//        this.description = description;
//        this.type = type;
//        this.img_url = img_url;
//    }
}
