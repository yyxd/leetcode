package arrays;

/**
 * Created by HinTi on 2019/9/2.
 * Goal:
 */
public class Problem674 {
    public static int findLengthOfLCIS(int[] nums) {
        int pre = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                pre++;
                max = Math.max(pre, max);
            } else
                pre = 1;
        }
        return max;
    }
}