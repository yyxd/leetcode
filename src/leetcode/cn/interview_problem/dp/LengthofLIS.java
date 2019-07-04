package leetcode.cn.interview_problem.dp;

/**
 * Created by Diane on 2019-07-04.
 * Goal: 求最长的上升序列
 */
public class LengthofLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[0])
        }
    }
}
