package com.ds.graph;

import java.util.ArrayList;

public class Node {
    int value;
    int out = 0;
    int in = 0;
    ArrayList<Node> nexts;
    ArrayList<Edge> edges;

    public Node(int value){
        this.value = value;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
