package com.ds.structure;


import com.ds.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class UnionFind {

    HashMap<Node, Node> fatherMap;
    HashMap<Node, Integer> sizeMap;

    public UnionFind(){
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
    };

    public void makeSets(ArrayList<Node> nodes){
        fatherMap.clear();
        sizeMap.clear();
        for (Node node: nodes) {
            fatherMap.put(node, null);
            sizeMap.put(node, 1);
        }
    }

    public Node findHead(Node node){
        Node curr = node;
        while (fatherMap.get(curr) != null){
            curr = fatherMap.get(curr);
        }
        return curr;
    }

    public boolean fromSameSet(Node n1, Node n2){
        if(n1 == null || n2 == null)
            return false;

        return findHead(n1) == findHead(n2);
    }

    public void union(Node n1, Node n2){
        if(n1 == null || n2 == null)
            return;
        Node h1 = findHead(n1);
        Node h2 = findHead(n2);

        int h1_size = sizeMap.get(h1);
        int h2_size = sizeMap.get(h2);


        if(h1 == h2)
            return;

        if(sizeMap.get(h1) >= sizeMap.get(h2)){
            fatherMap.put(h2, h1);
            sizeMap.put(h1, h1_size+h2_size);
        }else{
            fatherMap.put(h1, h2);
            sizeMap.put(h2, h1_size+h2_size);
        }
    }

}

