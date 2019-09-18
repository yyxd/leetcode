package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HinTi on 2019/9/13.
 * Goal:
 */
public class Graph {
    List<List<Edge>> graph;

    Graph(int n) {
        init(n);
    }

    // 初始化n个节点
    void init(int n) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
    }

    void addEdge(int i, int j, int val) {
        graph.get(i).add(new Edge(j, val));
    }

    void addWuXiangEdge(int i, int j, int val) {
        graph.get(i).add(new Edge(j, val));
        graph.get(j).add(new Edge(i, val));
    }

    int getSize() {
        return graph.size();
    }

    // 获取边
    List<Edge> getEdges(int node) {
        return graph.get(node);
    }
}