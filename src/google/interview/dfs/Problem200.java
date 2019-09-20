package google.interview.dfs;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by HinTi on 2019/9/17.
 * Goal: 岛屿的数量
 * 1. dfs 解法，dfs 一般都会有一个全局变量用于保存访问的状态
 * 如果需要回溯的话，需要清除状态。
 * 2. bfs 解法
 */
public class Problem200 {
    boolean[][] visited;
    int[] parents;

    // 使用并查集
    public int numIslandsWithUnion(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        parents = new int[rows * cols];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0')
                    parents[i * cols + j] = -1;
                else {
                    parents[i * cols + j] = i * cols + j;
                    ans++;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if(i-1>=0&&grid[i-1][j]=='1'&& merge(i*cols+j,(i-1)*cols+j)) ans--;
                    if(i+1<rows&&grid[i+1][j]=='1'&& merge(i*cols+j,(i+1)*cols+j)) ans--;
                    if(j-1>=0&&grid[i][j-1]=='1'&& merge(i*cols+j,i*cols+j-1)) ans--;
                    if(j+1<cols&&grid[i][j+1]=='1'&& merge(i*cols+j,i*cols+j+1)) ans--;
//                    int[] dx = {1, 0, -1, 0};
//                    int[] dy = {0, 1, 0, -1};
//                    for (int k = 0; k < 4; k++) {
//                        int x = dx[k] + i;
//                        int y = dy[k] + j;
//                        if (x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == '1')
//                            if (merge(i * cols + j, x * cols + y))
//                                ans--;
//                    }
                }
            }
        }
        return ans;
    }

    // 并查集路径优化
    private int find(int i) {
        if (parents[i] != i)
            parents[i] = find(parents[i]);
        return parents[i];
    }

    private boolean merge(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;
        parents[px] = py;
        return true;
    }


    public int numIslands(char[][] grid) {
        if (grid.length <= 0) return 0;
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
//        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public int bfs(char[][] grid) {
        if (grid.length <= 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                    queue.offer(new Pair<>(i, j));
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> cur = queue.poll();
                        int[] dx = {1, 0, -1, 0};
                        int[] dy = {0, 1, 0, -1};
                        for (int k = 0; k < 4; k++) {
                            int x = cur.getKey() + dx[k];
                            int y = cur.getValue() + dy[k];
                            if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                                queue.offer(new Pair<>(x, y));
                                grid[x][y] = '0';
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public void dfslow(char[][] grid, int i, int j) {
        visited[i][j] = true;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y] && grid[x][y] == '1')
                dfslow(grid, x, y);
        }
    }

    // 一个更好的解法，如果访问过某个节点，将他置为0 就不需要开辟一块visited的状态空间了

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j > grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }
}