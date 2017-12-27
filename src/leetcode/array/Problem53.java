package leetcode.array;

/**
 * Created by Diane on 2017/11/23.
 */
public class Problem53 {
    public static int maxSubArray(int[] nums) {
        int []dp = new int[nums.length];
        dp[0]=nums[0];
        int ans = dp[0];
        for (int i=1;i<nums.length;i++){
            //dp[i]是以i为结尾的最大的连续子序列的和
            dp[i] = nums[i]+(dp[i-1]>0?dp[i-1]:0);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }


}
