package leetcode.dp;

/**
 * Created by HinTi on 2019/9/19.
 * Goal: decode ways
 */
public class Problem91 {
    public int numDecodings(String s) {
        if (s.length() <= 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            int pre = s.charAt(i - 1) - '0';
            int cur = s.charAt(i) - '0';
            int sum = pre * 10 + cur;
            if (cur == 0)
                if (sum == 10 || sum == 20)
                    dp[i + 1] = dp[i - 1];
                else
                    return 0;
            else if (sum <= 26 && sum > 10)
                dp[i + 1] = dp[i - 1] + dp[i];
            else
                dp[i + 1] = dp[i];
        }
        return dp[n];
    }
}