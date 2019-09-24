package acmcoder.netEase;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-21.
 * Goal:
 */
public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int iCase = 1; iCase <= T; iCase++) {
            int n = scanner.nextInt();
            if (n == 0) {
                System.out.println(0);
                continue;
            } else if (n == 1) {
                System.out.println(1);
                continue;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();
            int[] dp = new int[n + 1];
            // dp[] 前面的和
            // 双指针 start 指向第一个满足的条件的位置
            int start = 0, end;
            dp[0] = 0;
            int ans = 0;
            int[] tmp = new int[n + 1];
            for (end = 1; end <= n; end++) {
                int cur = arr[end - 1];
                int preSum = dp[end - 1];
                if (cur > preSum) {
                    dp[end] = preSum + cur;
                    ans = Math.max(ans, end - start);
                    tmp[end] = end - start;
                } else {
                    while (start < end) {
                        preSum = preSum - arr[start];
                        if (preSum > cur) {
                            start++;
                        } else {
                            break;
                        }
                    }
                    start++;
                    dp[end] = preSum + cur;
                    ans = Math.max(ans, end - start);
                    tmp[end] = end - start;
                }
            }
//            System.out.println(Arrays.toString(dp));
//            System.out.println(Arrays.toString(tmp));
            System.out.println(ans);
        }
    }
}
