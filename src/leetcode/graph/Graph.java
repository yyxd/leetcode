package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diane on 2019/2/10.
 * Goal: 图的邻接矩阵的表示
 */
public class Graph {
    List<Node> nodes = new ArrayList<>();

    public void insertNode(Node node){
        nodes.add(node);
    }

    public void addEdge(Edge e){
        Node v1= e.startNode;
        v1.edges.add(e);
    }
}

class Node{
    String nodeName;//节点名称
    int val;
    int count;//节点的入度
    List<Edge> edges = new ArrayList<>();
}

class Edge{
    int weight;//边的权重
    Node startNode;//边的开始节点
    Node endNode;//边的结束节点
}
