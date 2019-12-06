package com.ds.graph;

import sun.jvm.hotspot.memory.EdenSpace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologySort {
    public static void topoSort(Graph graph){

        HashMap<Node, Integer> in_map = new HashMap<>();
        Queue<Node> que = new LinkedList<>();

        for (Node node: graph.nodes.values()){
            in_map.put(node, node.in);
            if(node.in == 0)
                que.offer(node);
        }

        while (!que.isEmpty()){
            Node curr = que.poll();
            System.out.println(curr.value);
            for (Node next : curr.nexts){
                in_map.put(next, in_map.get(next)-1);
                if(in_map.get(next) == 0)
                    que.offer(next);
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{0,2,1}, {0,3,1}, {0,4,2}, {0,5,2}};
        Graph graph = CreateGraph.createGraph(matrix);
        Node begin = graph.nodes.get(1);
        TopologySort.topoSort(graph);

    }
}
