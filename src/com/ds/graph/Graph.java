package com.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    HashMap<Integer, Node> nodes;
    ArrayList<Edge> edges;

    public Graph(){
        nodes = new HashMap<>();
        edges = new ArrayList<>();
    }

}
