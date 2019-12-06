package com.ds.graph;

import java.util.*;

public class PrimMinTree {
    public static ArrayList<Edge> prim(Graph graph){

        ArrayList<Edge> result = new ArrayList<>();

        Node curr = null;
        for(Node node : graph.nodes.values()){
            curr = node;
            break;
        }
        ArrayList<Node> nodes = new ArrayList<>();
        PriorityQueue<Edge> que = new PriorityQueue<>();

        nodes.add(curr);

        // while (nodes.size() < graph.nodes.values().size())
        while(!que.isEmpty()){
            Edge edge = que.poll();
            if(!nodes.contains(edge.to)){
                curr = edge.to;
                for (Edge e:curr.edges){
                    que.offer(e);
                }
                nodes.add(curr);
                result.add(edge);
            }
        }
        return result;
    }
}
