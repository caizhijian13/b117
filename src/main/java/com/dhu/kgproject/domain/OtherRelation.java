package com.dhu.kgproject.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.RelationshipEntity;

@Data
@RelationshipEntity(type = "relation")
public class OtherRelation extends Relationship{
    private String relName;
}
