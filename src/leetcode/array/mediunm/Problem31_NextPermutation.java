package leetcode.array.mediunm;

import javax.swing.*;
import java.util.Arrays;

/**
 * Created by HinTi on 2018/7/17.
 */
public class Problem31_NextPermutation {

    public static void nextPermutation2(int[] nums){
        int len = nums.length;
        int c=nums[len-1],i;

    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while (i>0&&nums[i]<=nums[i-1])
                i--;
        if(i>0){
            int j = nums.length-1;
            while(j>i&&nums[j]<=nums[i-1]) j--;
            int temp = nums[j];
            nums[j] = nums[i-1];
            nums[i-1] = temp;
        }
        Arrays.sort(nums,i,nums.length);

        for(int k:nums)
            System.out.print(k+"    ");
        System.out.println();
    }

    public static void main(String[] args) {
        int []nums = {1,5,1};
        nextPermutation2(nums);
        int []nums2 = {5,1,1};
        nextPermutation2(nums2);
        int []nums3 = {1,1,3,2,3,4,5,2};
        nextPermutation2(nums3);
        int []nums4 = {3,8,7,6,5,2};
        nextPermutation2(nums4);

    }
}
