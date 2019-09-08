package arrays;

/**
 * Created by HinTi on 2019/9/2.
 * Goal:
 */
public class Problem673 {
    public static int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] == dp[j] + 1)
                        count[i] += count[j];
                    else if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
//            System.out.printf("%d %d %d \n", nums[i], dp[i], count[i]);
            if (dp[i] == max)
                ans += count[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(findNumberOfLIS(nums));
    }
}