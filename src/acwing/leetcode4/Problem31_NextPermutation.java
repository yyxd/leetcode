package acwing.leetcode4;

import java.util.Arrays;

/**
 * Created by HinTi on 2018/11/19.
 */
public class Problem31_NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums.length <= 0) return;
        int index = nums.length - 1;
        int cmp = nums[index--];
        while (index >= 0) {
            if (cmp <= nums[index])
                cmp = nums[index--];
            else
                break;
        }
        if (index == -1) Arrays.sort(nums);
        else {
            int swap = nums.length - 1;
            while (swap > index) {
                if (nums[swap] <= nums[index])
                    swap--;
                else {
                    int temp = nums[swap];
                    nums[swap] = nums[index];
                    nums[index] = temp;
                    Arrays.sort(nums,index+1,nums.length);
                    break;
                }
            }
        }

        for (int i:nums)
            System.out.print(i+"\t");
    }


    public static void main(String[] args) {
        int nums[] = {1,1,5};
        nextPermutation(nums);
    }
}
