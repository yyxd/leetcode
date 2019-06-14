package leetcode.cn.interview_problem.array_problem;

import javax.swing.*;

/**
 * Created by HinTi on 2019/6/12.
 * Goal: 求除自身以外的数组乘积
 */
public class MultiProdcut {
    public int[] productExceptSelf(int[] nums) {
        int start = 1;
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = start;
            start*=nums[i];
        }
        int end = 1;
        for(int i = nums.length-1; i>=0;i--){
            ans[i] = ans[i]*end;
            end *=nums[i];
        }
        return ans;
    }
}
