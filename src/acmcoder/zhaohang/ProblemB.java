package acmcoder.zhaohang;

import java.util.*;

/**
 * Created by Diane on 2019-09-15.
 * Goal:
 */

class Edge {
    int end;
    int val;

    public Edge(int end, int val) {
        this.end = end;
        this.val = val;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    int index;

    public TreeNode(int index, int val) {
        this.index = index;
        this.val = val;
    }
}

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int c = scanner.nextInt();
            graph.get(u).add(new Edge(v, c));
            graph.get(v).add(new Edge(u, c));
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode root = new TreeNode(1, 0);
        nodes.add(root);
        boolean[] visited = new boolean[n + 1];
        while (!nodes.isEmpty()) {
            TreeNode top = nodes.poll();
            visited[top.index] = true;
            for (Edge edge : graph.get(top.index)) {
                if (!visited[edge.end]) {
                    TreeNode node = new TreeNode(edge.end, edge.val);
                    if (top.left == null)
                        top.left = node;
                    else
                        top.right = node;
                    nodes.add(node);
                }
            }
        }
        reverseTree(root);
        for (int i = 1; i <= n; i++)
            System.out.print(ans[i] + " ");
    }

    static int[] ans = new int[200005];

    static int reverseTree(TreeNode root) {
        if (root == null) return 0;
        else {
            int left = reverseTree(root.left);
            int right = reverseTree(root.right);
            ans[root.index] = Math.max(0, Math.max(left, right));
            return ans[root.index] + root.val;
        }
    }
}
