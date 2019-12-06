package com.ds.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(Graph graph, Node node){

        Queue<Node> que = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();

        que.offer(node);

        while (!que.isEmpty()){
            Node tmp = que.poll();
            System.out.println(tmp.value);
            for (Node n : tmp.nexts) {
                if (!set.contains(n)) {
                    que.offer(n);
                    set.add(n);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{0,1,2}, {0,1,3}, {0,1,4}, {0,2,3}, {0,2,7}, {0,7,3}, {0,3,5}, {0,4,6}};
        Graph graph = CreateGraph.createGraph(matrix);
        Node begin = graph.nodes.get(1);
        BFS.bfs(graph, begin);

    }
}
