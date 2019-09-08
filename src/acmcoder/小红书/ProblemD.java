package acmcoder.小红书;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-03.
 * Goal:
 */
public class ProblemD {
    static int si, sj, ei, ej;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        char[][] migong = new char[N + 1][N + 1];
        visited = new boolean[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            String s = scanner.nextLine();
            for (int j = 1; j <= N; j++) {
                migong[i][j] = s.charAt(j - 1);
                if (migong[i][j] == 'S') {
                    si = i;
                    sj = j;
                } else if (migong[i][j] == 'E') {
                    ei = i;
                    ej = j;
                }
            }
        }
        System.out.println(dfs(migong,si,sj,N,0));

    }

    public static int dfs(char[][] matrix, int curi, int curj, int n, int step) {
        if (curi == ei && curj == ej) return step;
        if (curi <= 0 || curj <= 0 || curi > n || curj > n) {
            if (curi <= 0) curi = n;
            if (curj <= 0) curi = n;
            if (curi > n) curi = 0;
            if (curj > n) curj = 0;
        }
        if (matrix[curi][curj] == '#' || visited[curi][curj])
            return -1;
        visited[curi][curj] = true;
        int right = dfs(matrix, curi + 1, curj, n, step + 1);
        int left = dfs(matrix, curi - 1, curj, n, step + 1);
        int up = dfs(matrix, curi, curj - 1, n, step + 1);
        int down = dfs(matrix, curi, curj + 1, n, step + 1);
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
