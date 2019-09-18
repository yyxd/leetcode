package contest.contest154;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by HinTi on 2019/9/15.
 * Goal:
 */
public class ProblemD {
    // 关键连接，利用拓扑排序找出关键路径
    static public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> keyConn = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> conn = connections.get(i);
            int a = conn.get(0);
            int b = conn.get(1);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] degree = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            degree[i] = graph.get(i).size();
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            List<Integer> ans = new ArrayList<>();
            for (int end : graph.get(cur)) {
                if (!visited[end]) {
                    ans.add(cur);
                    ans.add(end);
                    degree[end]--;
                    if (degree[end] == 1)
                        queue.add(end);
                    keyConn.add(ans);
                }
            }

        }
        return keyConn;
    }


    public static void main(String[] args) {
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> conn1 = new ArrayList<>();
        conn1.add(0);
        conn1.add(1);
        connections.add(conn1);
        List<Integer> conn2 = new ArrayList<>();
        conn2.add(1);
        conn2.add(2);
        connections.add(conn2);
        List<Integer> conn3 = new ArrayList<>();
        conn3.add(2);
        conn3.add(0);
        connections.add(conn3);
        List<Integer> conn4 = new ArrayList<>();
        conn4.add(1);
        conn4.add(3);
        connections.add(conn4);
        List<List<Integer>> res = criticalConnections(4, connections);
        System.out.println(res.size());

    }
}