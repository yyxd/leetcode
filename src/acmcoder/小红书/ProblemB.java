package acmcoder.小红书;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-03.
 * Goal:
 */
public class ProblemB {
    static boolean visited[][];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] matrix = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            matrix[a][b] = 1;
        }
        if (matrix[n - 1][m - 1] == 1) System.out.println(0);
        else if (matrix[0][0] == 1) System.out.println(0);
        else {
            int ans = dfs(matrix, 0, 0, n, m, 0);
            System.out.println(ans);
        }
    }

    public static int dfs(int[][] matrix, int curi, int curj, int n, int m, int step) {
        if (curi == n - 1 && curj == m - 1) return step;
        if (curi < 0 || curj < 0 || curi >= n || curj >= m || matrix[curi][curj] == 1 || visited[curi][curj]) return -1;
        visited[curi][curj] = true;
        int right = dfs(matrix, curi + 1, curj, n, m, step + 1);
        int left = dfs(matrix, curi - 1, curj, n, m, step + 1);
        int up = dfs(matrix, curi, curj - 1, n, m, step + 1);
        int down = dfs(matrix, curi, curj + 1, n, m, step + 1);
        visited[curi][curj] = false;
        int ans = 0;
        if (right != -1)
            ans = (ans == 0) ? right : Math.min(ans, right);
        if (left != -1)
            ans = (ans == 0) ? left : Math.min(ans, left);
        if (up != -1)
            ans = (ans == 0) ? up : Math.min(ans, up);
        if (down != -1)
            ans = (ans == 0) ? down : Math.min(ans, down);
        return ans;
    }
}
