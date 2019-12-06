package com.ds.graph;

import java.util.HashSet;
import java.util.Stack;

public class DFS {
    public static void dfs(Graph graph, Node node){
        HashSet<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        stack.push(node);
        set.add(node);
        System.out.println(node.value);

        while (!stack.isEmpty()){
            Node curr = stack.pop();
            for(Node n: curr.nexts){
                if(!set.contains(n)){
                    set.add(n);
                    stack.push(curr);
                    stack.push(n);
                    System.out.println(n.value);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2}, {0,1,3}, {0,1,4}, {0,2,3}, {0,2,7}, {0,7,3}, {0,3,5}, {0,4,6}};
        Graph graph = CreateGraph.createGraph(matrix);
        Node begin = graph.nodes.get(1);
        DFS.dfs(graph, begin);
    }
}
