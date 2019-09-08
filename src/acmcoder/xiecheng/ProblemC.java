package acmcoder.xiecheng;

/**
 * Created by Diane on 2019-09-04.
 * Goal:
 */

import java.util.Scanner;

public class ProblemC {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m, int[] array) {
        int n = array.length;
        if (n <= 0) return 0;
        int[][][] dp = new int[n + 1][n + 1][m + 1];
        // m 是从1-m 的
        // 完成从i到j 有k 个节点
        int[] sum = new int[n];
        sum[0] = array[0];
        for (int i = 1; i < n; i++) {
            sum[i] = array[i] + sum[i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++)
                if (i >= 1)
                    dp[i][j][1] = sum[j] - sum[i - 1];
                else
                    dp[i][j][1] = sum[j];
        }
        for (int i = 0; i < n; i++) {
            for (int k = 2; k <= m; k++)
                dp[i][i][k] = array[i];
        }
        for (int k = 2; k <= m; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int res = Integer.MAX_VALUE;
                    for (int t = i; t < j; t++) {
                        for (int p = 1; p < k; p++) {
                            int temp = Math.max(dp[i][t][p],dp[t + 1][j][k - p]);
                            res = Math.min(res, temp);
                        }
                    }
                    dp[i][j][k] = res;
                }

            }
        }
        return dp[0][n - 1][m];

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m, array);
        System.out.println(String.valueOf(res));
    }
}

