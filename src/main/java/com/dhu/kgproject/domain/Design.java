package com.dhu.kgproject.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@Data
@NodeEntity(label="Design")
public class Design extends Node{

//	@JsonIgnore
//	@Relationship(type="DesignTrend")
//	private List<com.dhu.kgproject.domain.Relationship> relationships;
	
	public Design() {}
	
}
