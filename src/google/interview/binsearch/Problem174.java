package google.interview.binsearch;

/**
 * Created by HinTi on 2019/9/11.
 * Goal: 地下城游戏
 */


public class Problem174 {
    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length <= 0) return 1;
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                int down = i + 1 < rows ? dp[i + 1][j] : Integer.MIN_VALUE;
                int right = j + 1 < cols ? dp[i][j + 1] : Integer.MIN_VALUE;
                if (i == rows - 1 && j == cols - 1)
                    dp[i][j] = Math.min(0, dungeon[i][j]);
                else
                    dp[i][j] = Math.min(0, Math.max(down, right) + dungeon[i][j]);
            }
        }
        return Math.max(0, -dp[0][0]) + 1;
    }

    public static void main(String[] args) {
       int[][] dungon =  {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(calculateMinimumHP(dungon));
    }
}

