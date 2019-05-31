package leetcode.cn.interview_problem.array_problem;


/**
 * Created by HinTi on 2019/5/31.
 * Goal: 乘积最大子序列
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int min = 1, max = 1;
        for (int i = 0; i < nums.length; i++) {
            int tmax = Math.max(max * nums[i], nums[i]);
            tmax = Math.max(tmax, min * nums[i]);
            int tmin = Math.min(min * nums[i], nums[i]);
            tmin = Math.min(tmin, max * nums[i]);
            max = tmax;
            min = tmin;
            if (ans < max) ans = max;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
