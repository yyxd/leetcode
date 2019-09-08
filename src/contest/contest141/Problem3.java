package contest.contest141;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Diane on 2019-06-16.
 * Goal:
 */
public class Problem3 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid.length];
        int len = pathLength(grid, 0, 0, 0, visited);
        return len == Integer.MAX_VALUE ? -1 : len;
    }

    public int pathLength(int[][] grid, int ci, int cj, int step, boolean[][] visited) {
        if (ci < 0 || cj < 0 || ci >= grid.length || cj >= grid.length) return Integer.MAX_VALUE;
        if (visited[ci][cj] || grid[ci][cj] == 1) return Integer.MAX_VALUE;
        if (ci == grid.length - 1 && cj == grid.length - 1) return step;
        visited[ci][cj] = true;
        int minstep = Integer.MAX_VALUE;
        int t1 = pathLength(grid, ci + 1, cj + 1, step + 1, visited);
        int t2 = pathLength(grid, ci - 1, cj + 1, step + 1, visited);
        int t3 = pathLength(grid, ci + 1, cj - 1, step + 1, visited);
        int t4 = pathLength(grid, ci - 1, cj - 1, step + 1, visited);
        int t5 = pathLength(grid, ci + 1, cj, step + 1, visited);
        int t6 = pathLength(grid, ci, cj + 1, step + 1, visited);
        int t7 = pathLength(grid, ci - 1, cj, step + 1, visited);
        int t8 = pathLength(grid, ci, cj - 1, step + 1, visited);
        visited[ci][cj] = false;
        minstep = Math.min(minstep, t1);
        minstep = Math.min(minstep, t2);
        minstep = Math.min(minstep, t3);
        minstep = Math.min(minstep, t4);
        minstep = Math.min(minstep, t5);
        minstep = Math.min(minstep, t6);
        minstep = Math.min(minstep, t7);
        minstep = Math.min(minstep, t8);
        return minstep;
    }

    public int shortestPathBinaryMatrixRight(int[][] grid) {
        int rows=grid.length,cols=grid[0].length,step=1;
        if(grid[0][0]==1||grid[rows-1][cols-1]==1) return -1;
        int[][] visited=new int[rows][cols];
        visited[0][0]=1;
        Queue<int[]> que=new LinkedList<>();
        que.offer(new int[]{0,0});
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                int[] cur=que.poll();
                if(cur[0]==rows-1&&cur[1]==cols-1) return step;
                for(int m=-1;m<2;m++){
                    for(int n=-1;n<2;n++){
                        int r=cur[0]+m,c=cur[1]+n;
                        if(r>=0&&c>=0&&r<rows&&c<cols&&visited[r][c]==0&&grid[r][c]==0){
                            visited[r][c]=1;
                            que.offer(new int[]{r,c});
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
