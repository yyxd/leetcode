package leetcode.dp;

/**
 * Created by HinTi on 2019/9/16.
 * Goal: 编辑距离 经典的dp 问题
 * 转化状态：
 * dp[i][j]
 * 如果word1.charAt(i)==word2.charAt(j)
 * 可以由 dp[i-1][j] 增加一个字符，或者由dp[i][j-1] 删除一个字符，或者 dp[i-1][j-1] 替换一个字符
 */
public class Problem72_EditDistance {
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++)
            dp[i][0] = i;
        for (int j = 1; j <= m; j++)
            dp[0][j] = j;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String  word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }
}