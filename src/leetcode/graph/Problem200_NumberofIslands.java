package leetcode.graph;

/**
 * Created by Diane on 2019/2/10.
 * Goal: 给定字符数组，0表示水，1表示陆地，查找二维字符数组中有几块岛屿
 * Solution: 遍历数组，遇到1时，使用深度/广度遍历，将连通的1都置为0，
 */
public class Problem200_NumberofIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid.length<=0) return 0;
        for (int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i,int j,char[][]grid){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0')
            return;
        grid[i][j]='0';
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
    }
}
