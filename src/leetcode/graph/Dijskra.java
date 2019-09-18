package leetcode.graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijskra {
    // 邻接表

    static int[] dijskra(Graph graph, int start) {
        int n = graph.getSize();
        Queue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.val - o2.val;
            }
        });
        queue.add(new Edge(start, 0));
        int[] ans = new int[n];
        ans[start] = 0;
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            int curStart = cur.end;
            if (!visited[curStart]) {
                visited[curStart] = true;
                ans[curStart] = cur.val;
                List<Edge> edges = graph.getEdges(curStart);
                for (int i = 0; i < edges.size(); i++)
                    queue.offer(new Edge(edges.get(i).end, cur.val + edges.get(i).val));
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 2, 2);
        g.addEdge(0, 1, 1);
        g.addEdge(1, 4, 3);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 4, 2);

        int[] ans = dijskra(g, 0);
        for (int i = 0; i < 5; i++) {
            System.out.println("0-" + i + ": " + ans[i]);
        }

        System.out.println(TopSort.topSort(g));
    }

}