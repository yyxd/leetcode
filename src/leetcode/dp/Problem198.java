package leetcode.dp;

/**
 * Created by HinTi on 2018/8/24.
 */
public class Problem198 {
    public static int rob(int[] nums) {
        if (nums.length<=0) return 0;
        int p =0, q =nums[0],ans = q;
        for(int i = 1;i<nums.length;i++)
        {
            int temp = nums[i]+p;
            if(temp>q) ans = temp;
            else ans = q;
            p = q;
            q = ans;
        }
        return ans;
    }
}
