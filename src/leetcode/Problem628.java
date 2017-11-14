package leetcode;

import sun.security.util.Length;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by hh23485 on 2017/11/4.
 */
public class Problem628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int max = Math.max(nums[len-1]*nums[len-2]*nums[len-3],nums[len-1]*nums[0]*nums[1]);
        return max;
    }

    public static void main(String[] args) {
        Problem628 problem628 = new Problem628();
        int []nums = {1,2,3};
        System.out.println(problem628.maximumProduct(nums));
        int []nums2 = {1,2,3,4};
        System.out.println(problem628.maximumProduct(nums2));
    }
}
