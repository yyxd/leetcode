package acwing.leetcode4.week1;

import java.util.HashMap;

/**
 * Created by HinTi on 2018/11/20.
 * Goal:
 */
public class Problem41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer,Boolean> numberMap = new HashMap<>();
        int max = 0;
        for(int i = 0;i<nums.length;i++) {
            numberMap.put(nums[i], true);
            if(max<nums[i]) max = nums[i];
        }
        int ans;
        for( ans = 1;ans<=max+1;ans++)
        {
            if(!numberMap.containsKey(ans))
                break;
        }
        return ans;
    }
}
