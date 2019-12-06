package com.ds.graph;

public class CreateGraph {
    public static Graph createGraph(int[][] matrix){

        Graph graph = new Graph();

        for (int i=0; i<matrix.length; ++i){

            // matrix[i][0] --> weight
            // matrix[i][1] --> from node value
            // matrix[i][2] --> to node value

            // 如果新添的结点还不存在，把他们加到图里
            if(!graph.nodes.containsKey(matrix[i][1])){
                Node node = new Node(matrix[i][1]);
                graph.nodes.put(matrix[i][1], node);
            }
            if(!graph.nodes.containsKey(matrix[i][2])){
                Node node = new Node(matrix[i][2]);
                graph.nodes.put(matrix[i][2], node);
            }

            // 在图里找到from和to两个点，新建一条连接他们的边
            Node from = graph.nodes.get(matrix[i][1]);
            Node to = graph.nodes.get(matrix[i][2]);
            Edge edge = new Edge(matrix[i][0], from, to);

            // 把新建的边放到图里
            graph.edges.add(edge);

            // 更新两个结点的各项状态
            from.out++;
            to.in++;
            from.nexts.add(to);
            from.edges.add(edge);
        }
        return graph;
    }

}
