package acmcoder.hulu;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Diane on 2019-09-05.
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

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int[][] count = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
                count[i][j] = Integer.MAX_VALUE;
            }
        }
        count[0][0] = 0;
        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.pop();
            for (int i = 0; i < 4; i++) {
                int x = cur.i + dx[i];
                int y = cur.j + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    if (count[x][y] > count[cur.i][cur.j]) {
                        count[x][y] = count[cur.i][cur.j];
                        if (matrix[x][y] == 1)
                            count[x][y]++;
                        queue.offer(new Node(x, y));
                    }
                }
            }
        }
        System.out.println(count[n - 1][n - 1]);
    }
}
