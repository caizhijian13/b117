package com.dhu.kgproject.domain;

import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type = "instance_of")
public class LowerInstance_of extends Relationship {
}
