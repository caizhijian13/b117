package com.dhu.kgproject.repositories;

import com.dhu.kgproject.domain.Node;
import org.neo4j.cypher.internal.frontend.v2_3.ast.functions.Str;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface NodeRepository extends Neo4jRepository<Node,Long> {

//    Node findNodeByName(@Param("name") String name);

    @Query("MATCH (n{name:{name}}) return n")
    Node findByName(@Param("name") String name);

//    Collection<Node> findByNameLike(@Param("name") String name);

    @Query("MATCH(n) where n.name contains {name} return n")
    Collection<Node> findNodesByNameLike(@Param("name") String name);

    Collection<Node> findByNameLike(@Param("name") String name);

    @Query("MATCH (n)-[s]-(m)"+" WHERE n.name={name}"+" RETURN n,s,m")
    Collection<Node> selectgraph(@Param("name") String name);

    @Query("MATCH (n)-[r:class_of]-(m) RETURN n,r,m LIMIT {limit}")
    Collection<Node> graph(@Param("limit") int limit);



}
