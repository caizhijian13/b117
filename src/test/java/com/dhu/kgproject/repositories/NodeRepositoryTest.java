package com.dhu.kgproject.repositories;

import com.dhu.kgproject.domain.Company;
import com.dhu.kgproject.domain.FabricInstance;
import com.dhu.kgproject.domain.Node;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.cypher.internal.compiler.v2_3.No;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NodeRepositoryTest {
    @Autowired
    NodeRepository repository;

    @Autowired
    CompanyRepository companyRepository;
//    @Test
//    public void findOne(){
//        Node result = repository.findNodeByName("asd标准");
////        Assert.assertNotNull(result);
//        System.out.println(result.getName());
//    }

    @Test
    public void findFaric(){
        Collection<FabricInstance> nodes = companyRepository.findFabricInstance("牛津布");
        if(nodes.isEmpty()){
            System.out.println("null");
        }
        else
            for (FabricInstance node:nodes){
                System.out.println(node.getName());
            }
    }

    @Test
    public void findCompany(){
        Company node = companyRepository.findCompanyByFabric(" 珍珠罗马布");

                System.out.println(node.getName());
    }


    @Test
    public void findLike(){
        Collection<Node> nodes = repository.findNodesByNameLike("型");
        if(nodes.isEmpty()){
            System.out.println("null");
        }
        else
        for (Node node:nodes){
            System.out.println(node.getName());
        }
    }

    @Test
    public void findByIdTest(){
        Integer a = 1699;
        Long b = a.longValue();
        System.out.println(a.longValue());
        Node node = repository.findNodeById( b);
        System.out.println(node.getId());
    }

    @Test
    public void selectgraph(){
        Collection<Node> nodes = repository.selectgraph("服装款式设计");
        for (Node node: nodes){
//            System.out.println(node.getRelationships());
            System.out.println(node.getName());
        }
    }

    @Test
    public void indexTest(){
        Long a = Long.valueOf(2266);
        Collection<Node> nodes = repository.graph(a);
        for (Node node: nodes){
            System.out.println(node);
        }
    }

    @Test
    public void selectGIdTest(){
        Integer a = 1699;
        Long b = a.longValue();
        System.out.println(a.longValue());
        Collection<Node> nodes = repository.selectGraphById(b);
        for (Node node: nodes){
//            System.out.println(node.getRelationships());
            System.out.println(node.getName());
        }
    }

    @Test
    public void select(){
        Integer a = 2492;
        Long b = a.longValue();
        System.out.println(a.longValue());
        Collection<Node> nodes = repository.selectRelatedNodes(b);
        for (Node node: nodes){
//            System.out.println(node.getRelationships());
            System.out.println(node.getName());
        }
    }
}