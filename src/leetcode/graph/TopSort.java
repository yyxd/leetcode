package leetcode.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by HinTi on 2019/9/13.
 * Goal: 拓扑排序
 */
class TopNode {
    int node;
    int time;

    public TopNode(int node, int time) {
        this.node = node;
        this.time = time;
    }
}

public class TopSort {
    public static int topSort(Graph g) {
        int[] count = new int[g.getSize()];
        int[] startTime = new int[g.getSize()];
        for (int i = 0; i < g.getSize(); i++) {
            List<Edge> edges = g.getEdges(i);
            for (Edge edge : edges) {
                count[edge.end]++;
                startTime[edge.end] = 0;
            }
        }
        Queue<TopNode> queue = new LinkedList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)
                queue.add(new TopNode(i, 0));
        }
        int lastTime = 0;
        while (!queue.isEmpty()) {
            TopNode top = queue.poll();
            lastTime = Math.max(lastTime, top.time);
            List<Edge> edges = g.getEdges(top.node);
            for (Edge edge : edges) {
                if (--count[edge.end] == 0) {
                    int st = top.time + edge.val;
                    queue.add(new TopNode(edge.end, st));
                    startTime[edge.end] = st;
                }
            }
        }
        for (int i = 0; i < g.getSize(); i++)
            System.out.printf("%d\t start time = %d\n", i, startTime[i]);
        return lastTime;
    }
}