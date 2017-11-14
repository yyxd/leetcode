package leetcode;
/**
 * Created by hh23485 on 2017/10/23.
 */
public class Main {
    public static void main(String[] args) {
        problem695 p695 = new problem695();
        int [][]grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int [][]grid2 = {{0,0,1,0,0,0,0,1,0,0,0,0,0}};
        int [][]grid3 = {{0,0,0,0,0,0,0}};
        int [][]grid4 = {{0,0,1,1,1,0,0,1,0,0,0,0,0}};
        System.out.println(p695.maxAreaOfIsland(grid));
        System.out.println(p695.maxAreaOfIsland(grid2));
        System.out.println(p695.maxAreaOfIsland(grid3));
        System.out.println(p695.maxAreaOfIsland(grid4));
    }


}
