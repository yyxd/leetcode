package leetcode.matrix;

import java.util.LinkedList;

/**
 * Created by Diane on 2019-09-04.
 * Goal:
 */
class Node {
    int i;
    int j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Problem542_01matrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length <= 0) return matrix;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] ans = new int[rows][cols];
        LinkedList<Node> queue = new LinkedList<>();
        for (int i = 0; i <= matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0)
                    queue.add(new Node(i, j));
                else
                    ans[i][i] = Integer.MAX_VALUE;
            }
        }
        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Node cur = queue.pop();
            for (int i = 0; i < 4; i++) {
                int nx = cur.i + dx[i];
                int ny = cur.j + dy[i];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    if (ans[nx][ny] > ans[cur.i][cur.j] + 1) {
                        ans[nx][ny] = ans[cur.i][cur.j] + 1;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }
        return ans;
    }

}
