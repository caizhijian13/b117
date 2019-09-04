package com.dhu.kgproject.repositories;

import com.dhu.kgproject.domain.Company;
import com.dhu.kgproject.domain.FabricInstance;
import com.dhu.kgproject.domain.Node;
import org.neo4j.cypher.internal.frontend.v2_3.ast.functions.Str;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface NodeRepository extends Neo4jRepository<Node,Long> {

//    Node findNodeByName(@Param("name") String name);


    @Query("match(n) where id(n) = {id} return n")
    Node findNodeById(Long id);

    @Query("MATCH (n{name:{name}}) return n")
    Collection<Node> findByName(@Param("name") String name);

//    Collection<Node> findByNameLike(@Param("name") String name);

    @Query("MATCH(n) where n.name contains {name} return n")
    Collection<Node> findNodesByNameLike(@Param("name") String name);

    Collection<Node> findByNameLike(@Param("name") String name);

    @Query("MATCH (n)-[s]-(m)"+" WHERE n.name={name}"+" RETURN n,s,m")
    Collection<Node> selectgraph(@Param("name") String name);

    @Query("MATCH (n)-[r*1..2]-(m) where id(n)={id} RETURN n,r,m")
    Collection<Node> graph(@Param("id") Long id);

    @Query("MATCH (n)-[s]-(m) WHERE id(n)={id} RETURN n,s,m")
    Collection<Node> selectGraphById(@Param("id") Long id);

    @Query("match(n1)<-[r1:Kind_of|Include]-(m),(n2)<-[r2:Kind_of|Include]-(m) where id(n1)={id} and type(r1)=type(r2) return n2")
    Collection<Node> selectRelatedNodes(@Param("id") Long id);

    @Query("match(n)-[r*1..]->(m) where id(n)={id} return count(distinct m)")
    Integer numOfKids(@Param("id") Long id);

    @Query("match(n) return id(n)")
    List<Long> IdList();

    @Query("match(n)-[r]->(m) where id(r) = {id} return r.relativity")
    Double selectRelativity(@Param("id")Long id);

    @Query("match(n) where id(n)={id} set n.size = {size}")
    void setSize(@Param("id")Long id,@Param("size")Double size);

    @Query("CALL db.propertyKeys() YIELD propertyKey AS prop\n" +
            "MATCH (n)\n" +
            "WHERE id(n)={id} and n[prop] IS NOT NULL \n" +
            "RETURN prop")
    List<String> findProperties(@Param("id")Long id);
}
