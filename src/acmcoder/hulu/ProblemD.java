package acmcoder.hulu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Diane on 2019-09-05.
 * Goal:
 */
public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        int[][] count = new int[n][n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(arr[j]);
                count[i][j] = set.size();
            }
        }
        long ans = schedule(arr, k + 1, count);
        System.out.println(ans);
    }

    public static long schedule(int[] nums, int m, int[][] count) {
        int size = nums.length;
        long[][] arr = new long[m + 1][size];

        for (int i = 0; i < size; i++) {
            arr[0][i] = count[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = size - 1; j >= i; j--) {
                arr[i][j] = Integer.MIN_VALUE;
                for (int k = j; k >= i; k--) {
                    arr[i][j] = Math.max(arr[i][j],
                            arr[i - 1][k - 1] + (count[k][j]));
                }
            }
        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < size; j++)
//                System.out.print(arr[i][j] + " ");
//            System.out.println();
//        }
        long result = arr[m - 1][size - 1];
        return result;
    }

    static int schedule2(int m, int n, int[] array, int[][] count) {
        if (n <= 0) return 0;
        int[][][] dp = new int[n + 1][n + 1][m + 1];
        // m 是从1-m 的
        // 完成从i到j 有k 个节点
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++)
                dp[i][j][1] = count[i][j];
        }
        for (int k = 2; k <= m; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int res = dp[i][j][k - 1];
                    for (int t = i; t < j; t++) {
                        for (int p = 1; p < k; p++) {
                            int temp = dp[i][t][p] + dp[t + 1][j][k - p];
                            res = Math.max(res, temp);
                        }
                    }
                    dp[i][j][k] = res;
                }

            }
        }
        return dp[0][n - 1][m];

    }
}
