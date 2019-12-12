package com.dhu.kgproject.services;


import com.dhu.kgproject.DTO.Property;
import com.dhu.kgproject.domain.Kind_of;
import com.dhu.kgproject.domain.Node;
import com.dhu.kgproject.domain.Relationship;
import com.dhu.kgproject.repositories.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class NodeService {
    @Autowired
    private final NodeRepository  repository;

    public NodeService(NodeRepository repository) {
        this.repository = repository;
    }

    private Map<String,Object> toD3Format(Collection<Node> nodes){
        List<Map<String,Object>> Allnodes = new ArrayList<>();
        List<Map<String,Object>> rels = new ArrayList<>();
        int i = 0;
        Iterator<Node> result = nodes.iterator();
        while(result.hasNext()){
            int source;
            Node node = result.next();
            Map<String,Object> no = new HashMap<>();
            no.put("id",node.getId());
            no.put("name",node.getName());
            no.put("description",node.getDescription());
            no.put("lable",node.getMyClass());
            no.put("size",node.getSize());
            if(Allnodes.indexOf(no)==-1){
                Allnodes.add(no);
                source = i++;
            }
            else{
                source = Allnodes.indexOf(no);
            }
            if(node.getLowerInclude() != null){
                for(Relationship re: node.getLowerInclude()){
                    Map<String,Object> nodee = new HashMap<>();
                    nodee.put("id",re.getEndNode().getId());
                    nodee.put("name",re.getEndNode().getName());
                    nodee.put("description",re.getEndNode().getDescription());
                    nodee.put("lable",re.getEndNode().getMyClass());
                    nodee.put("size",re.getEndNode().getSize());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","Include"));
                }
            }

            if(node.getAttribute_of() != null){
                for(Relationship re: node.getAttribute_of()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription(),
                                                    "lable",re.getEndNode().getMyClass(),"size",re.getEndNode().getSize());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","Attribute_of"));
                }
            }

            if(node.getInstance_of() != null){
                for(Relationship re: node.getInstance_of()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription(),
                                                    "lable",re.getEndNode().getMyClass(),"size",re.getEndNode().getSize());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","Instance_of"));
                }
            }

            if(node.getKind_of() != null){
                for(Relationship re: node.getKind_of()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription(),
                                                    "lable",re.getEndNode().getMyClass(),"size",re.getEndNode().getSize());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type", "Kind_of"));
                }
            }

            if(node.getPart_of() != null){
                for(Relationship re: node.getPart_of()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription(),
                                                    "lable",re.getEndNode().getMyClass(),"size",re.getEndNode().getSize());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","Part_of"));
                }
            }

            if(node.getNext() != null){
                for(Relationship re: node.getNext()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription(),
                                                    "lable",re.getEndNode().getMyClass(),"size",re.getEndNode().getSize());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","next"));
                }
            }


            if(node.getFit() != null){
                for(Relationship re: node.getFit()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription(),
                                                    "lable",re.getEndNode().getMyClass(),"size",re.getEndNode().getSize());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","适合","relativity",re.getRelativity()));
                }
            }
            if(node.getUnfit() != null){
                for(Relationship re: node.getUnfit()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription(),
                                                    "lable",re.getEndNode().getMyClass(),"size",re.getEndNode().getSize());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","不适合","relativity",re.getRelativity()));
                }
            }
            if(node.getMatch() != null){
                for(Relationship re: node.getMatch()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription(),
                                                    "lable",re.getEndNode().getMyClass(),"size",re.getEndNode().getSize());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","匹配"));
                }
            }
            if(node.getRel() != null){
                for(Relationship re: node.getRel()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription(),
                            "lable",re.getEndNode().getMyClass(),"size",re.getEndNode().getSize());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","rel"));
                }
            }
            if(node.getCompany_ofs()!= null){
                for(Relationship re: node.getCompany_ofs()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription(),
                            "lable",re.getEndNode().getMyClass(),"size",re.getEndNode().getSize());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","company_of"));
                }
            }
            if(node.getFabric_trends()!= null){
                for(Relationship re: node.getFabric_trends()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription(),
                            "lable",re.getEndNode().getMyClass(),"size",re.getEndNode().getSize());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","fabric_trend"));
                }
            }
            if(node.getColor_trends()!= null){
                for(Relationship re: node.getColor_trends()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription(),
                            "lable",re.getEndNode().getMyClass(),"size",re.getEndNode().getSize());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","color_trend"));
                }
            }
        }
        int index = 0;
        for (Map<String,Object> m: Allnodes
             ) {
            m.put("index",index++);
        }
        return map("nodes",Allnodes,"links",rels);
    }



    private Map<String, Object> map(String source, Object source1, String target, Object target1) {
        Map<String,Object> result = new HashMap<String,Object>(2);
        result.put(source,source1);
        result.put(target,target1);
        return result;
    }

    private Map<String, Object> map(String key1,Object value1,String key2,Object value2,String key3,Object value3) {
        Map<String,Object> result = new HashMap<String ,Object>(3);
        result.put(key1,value1);
        result.put(key2,value2);
        result.put(key3,value3);
        return result;
    }

    private Map<String, Object> map(String key1,Object value1,String key2,Object value2,String key3,Object value3,String key4,Object value4) {
        Map<String,Object> result = new HashMap<String ,Object>(3);
        result.put(key1,value1);
        result.put(key2,value2);
        result.put(key3,value3);
        result.put(key4,value4);
        return result;
    }

    private Map<String, Object> map(String key1,Object value1,String key2,Object value2,String key3,Object value3,String key4,Object value4,String key5,Object value5) {
        Map<String,Object> result = new HashMap<String ,Object>(3);
        result.put(key1,value1);
        result.put(key2,value2);
        result.put(key3,value3);
        result.put(key4,value4);
        result.put(key5,value5);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<Node> findByName(String name){
        Collection<Node> result = repository.findByName(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<Node> findNodesByNameLike(String name){
        Collection<Node> result = repository.findNodesByNameLike(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<Node> findByNameLike(String name){
        Collection<Node> result = repository.findByNameLike(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<Node> selectRelatedNodes(Long id){
        Collection<Node> result = repository.selectRelatedNodes(id);
        return result;
    }

    @Transactional(readOnly = true)
    public Map<String,Object> selectgraph(String name){
            Collection<Node> result = repository.selectgraph(name);
            return toD3Format(result);
    }

    @Transactional(readOnly = true)
    public Map<String ,Object> graph(Long id){
        Collection<Node> result = repository.graph(id);
        return toD3Format(result);
    }

    @Transactional(readOnly = true)
    public Map<String,Object> selectgraphById(Long id){
        Collection<Node> result = repository.selectGraphById(id);
        return toD3Format(result);
    }

    @Transactional(readOnly = true)
    public Node selectNodeById(Long id){
        Node result = repository.findNodeById(id);
        return result;
    }


    public void setNodeSize(){

        List<Long> Ids = repository.IdList();
        for(Long id : Ids) {
            Double size = 25d;
            //size = size+ ((1/(1+Math.exp(-repository.numOfKids(id)/50d)))-0.5)*100;
            size = size + repository.numOfKids(id)/100d;
            if(size>35d)
                size = 35d;
            repository.setSize(id,size);
            System.err.println(String.format("the size of [%s] is [%s] ",id,size));
        }
    }

    /**
     * 获取节点的属性集合
     * @param id
     * @return
     */
    public List<Property> findProperties(Long id ){
        List<Property> propertyList = new ArrayList<>();
        List<String> keys = repository.findPropertiesKey(id);
        List<String> values = repository.findPropertiesValue(id);
        int length = keys.size();
        for(int i = 0; i< length; i++){

            if(!keys.get(i).equals("name") && !keys.get(i).equals("description") && !keys.get(i).equals("image")){
                Property p = new Property();
                p.setKey(keys.get(i));
                p.setValue(values.get(i));
                propertyList.add(p);
            }

        }
        return propertyList;
    }


    //通过名字获取一个对象的所有属性
    public Map<String, Object> findPropertiesByName(String name){
        Collection<Node> nodes = repository.findNodesByNameLike(name);
        Object node = nodes.iterator().next();
        Map<String,Object> map = new HashMap<>();
        Field[] fields = node.getClass().getDeclaredFields();
        for (Field field:fields
             ) {
            field.setAccessible(true);
            try {
                map.put(field.getName(),field.get(node));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
