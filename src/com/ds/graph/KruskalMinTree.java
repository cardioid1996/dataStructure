package com.ds.graph;

import com.ds.structure.UnionFind;
import com.sun.xml.internal.xsom.XSWildcard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KruskalMinTree {
    public static ArrayList<Edge> kruskal(Graph graph){

        ArrayList<Edge> result = new ArrayList<>();

        PriorityQueue<Edge> que = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });

        for (Edge e : graph.edges)
            que.offer(e);

        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(new ArrayList<Node>(graph.nodes.values()));

        while(!que.isEmpty()){
            Edge edge = que.poll();
            if(!unionFind.fromSameSet(edge.from, edge.to)){
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }

        return result;

    }
}
