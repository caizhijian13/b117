package com.dhu.kgproject.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@Data
@NodeEntity
public class Color extends Node{

	private String colorid;
	
//	@JsonIgnore
//	@Relationship(type="INCLUDE",direction=Relationship.INCOMING)
//	private List<com.dhu.kgproject.domain.Relationship> relationships;

//	private List<TtoColor> ttocolors;
	
	public Color() {}
//	public Color(String colorid,String name) {
//		this.colorid=colorid;
//		this.name=name;
//	}

	
//	public List<TtoColor> getTtocolors() {
//		return ttocolors;
//	}

}
