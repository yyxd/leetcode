package leetcode.graph;

import java.util.*;

/**
 * Created by HinTi on 2019/9/13.
 * Goal:
 */
class PrimeEdge {
    int s;
    int e;
    int val;

    public PrimeEdge(int s, int e, int val) {
        this.s = s;
        this.e = e;
        this.val = val;
    }
}

public class Prim {
    // 使用了优先队列
    public static List<PrimeEdge> getPrimTree(Graph graph) {
        Set<Integer> visited = new HashSet<>();
        int start = 0;
        int weight = 0;
        List<PrimeEdge> ans = new ArrayList<>();
        // 将未访问的边按照优先队列进行组织
        Queue<PrimeEdge> queue = new PriorityQueue<>(new Comparator<PrimeEdge>() {
            @Override
            public int compare(PrimeEdge o1, PrimeEdge o2) {
                return o1.val - o2.val;
            }
        });
        for (Edge edge : graph.getEdges(start))
            queue.add(new PrimeEdge(start, edge.end, edge.val));
        visited.add(start);
        while (visited.size() < graph.getSize()) {
            PrimeEdge nextEdge = null;
            while (!queue.isEmpty()) {
                nextEdge = queue.poll();
                if (!visited.contains(nextEdge.e))
                    break;
            }
            if (nextEdge == null || visited.contains(nextEdge.e)) break;
            int cur = nextEdge.e;
            visited.add(cur);
            ans.add(nextEdge);
            weight += nextEdge.val;
            for (Edge edge : graph.getEdges(cur)) {
                if (!visited.contains(edge.end))
                    queue.add(new PrimeEdge(cur, edge.end, edge.val));
            }
        }
        System.out.println(weight);
        return ans;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addWuXiangEdge(0,1,6);
        graph.addWuXiangEdge(0,2,1);
        graph.addWuXiangEdge(0,3,5);
        graph.addWuXiangEdge(1,2,5);
        graph.addWuXiangEdge(1,4,3);
        graph.addWuXiangEdge(2,3,5);
        graph.addWuXiangEdge(2,4,6);
        graph.addWuXiangEdge(2,5,4);
        graph.addWuXiangEdge(3,5,2);
        graph.addWuXiangEdge(4,5,6);
        List<PrimeEdge> ans = getPrimTree(graph);
        for(PrimeEdge edge:ans){
            System.out.printf("%d-%d:%d\n",edge.s,edge.e,edge.val);
        }
    }
}