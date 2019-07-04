package leetcode.cn.interview_problem.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diane on 2019-07-04.
 * Goal:
 */
public class NumSquare {
    public static int numSquares(int n) {
        List<Integer> nums = new ArrayList<>();
        int i = 2;
        while (i * i <= n) {
            nums.add(i*i);
            i++;
        }
        int []dp = new int[n + 1];
        for (int j = 0; j < dp.length; j++) {
            dp[j] = j;
        }
        for (int k = 2; k <= n; k++) {
            for (int j = 0; j < nums.size(); j++) {
                int used = k - nums.get(j);// 如果使用当前的平方数
                if (used >= 0)
                   dp[k] = Math.min(dp[used] + 1, dp[k]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        numSquares(12);
    }
}
