package acwing.leetcode4.week2;

/**
 * Created by HinTi on 2018/11/29.
 * Goal: 很巧妙的想法，先正向计算一遍ans[k] = nums[0]乘到nums[k-1]，在逆向乘一遍
 */
public class Problem238_Product_of_ArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums){
        int[] ans = new int[nums.length];
        if(nums.length == 0) return ans;
        int runningprefix = 1;
        for(int i=0;i<nums.length;i++){
            ans[i] = runningprefix;
            runningprefix *= nums[i];
        }
        int runningsufix = 1;
        for(int i = nums.length-1;i>=0;i--){
            ans[i]*=runningsufix;
            runningsufix *=nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        int[] output = productExceptSelf(input);
        for (int i:output){
            System.out.println(i);
        }
    }
}
