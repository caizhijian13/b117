package com.dhu.kgproject.repositories;

import com.dhu.kgproject.domain.Company;
import com.dhu.kgproject.domain.FabricInstance;
import com.dhu.kgproject.domain.Node;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface CompanyRepository extends Neo4jRepository<Node,Long> {
    //查询面辅料实例
    @Query("match(n:fabric_concept{name:{name}})-[:instance_of]->(m:fabric_instance) return m")
    Collection<FabricInstance> findFabricInstance(@Param("name") String name);

    //通过面辅料实例查询企业
    @Query("match(n:fabric_instance{name:{name}})-[:company_of]->(m:company) return m")
    Company findCompanyByFabric(@Param("name") String name);
}
