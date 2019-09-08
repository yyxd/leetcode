package microsoft;

/**
 * Created by HinTi on 2019/9/3.
 * Goal:
 */
public class Problem152_MaxProduct {
    public static int maxProduct(int[] nums) {
        if (nums.length <= 0) return 0;
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMin[i] = Math.min(nums[i], Math.min(nums[i] * dpMin[i - 1], nums[i] * dpMax[i - 1]));
            dpMax[i] = Math.max(nums[i], Math.max(nums[i] * dpMin[i - 1], nums[i] * dpMax[i - 1]));
            ans = Math.max(ans,dpMax[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));

    }
}