package leetcode.array;

import java.util.Arrays;

/**
 * Created by HinTi on 2018/7/9.
 */
public class Problem16_3SumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3)
            return 0;
        Arrays.sort(nums);
        int ans = 0, diff = Integer.MAX_VALUE;
        for(int i =0;i<=nums.length-3;i++)
        {
            int s = i+1,e = nums.length-1;
            while (s<e){
                int sum = nums[i]+nums[e]+nums[s];
                if(sum<target)
                    s++;
                else if(sum>target)
                    e--;
                else
                    return sum;
                int temp = Math.abs(sum-target);
                if(temp<diff) {
                    diff = temp;
                    ans = sum;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int ans = threeSumClosest(nums,1);
        System.out.println(ans);
    }
}
