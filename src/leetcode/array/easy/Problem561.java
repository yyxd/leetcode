package leetcode.array.easy;

import java.util.Arrays;

/**
 * Created by hh23485 on 2017/11/8.
 */
public class Problem561 {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum =0;
        for(int i=0;i<nums.length;i+=2){
            sum+=nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
