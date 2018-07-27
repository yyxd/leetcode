package leetcode.array.easy;

/**
 * Created by Diane on 2017/11/21.
 */
public class Problem268 {
    public static int missingNumber(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < nums.length)
                if (nums[Math.abs(nums[i])] == 0)
                    flag = false;
                else
                    nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return i;
            if (nums[i] == 0 && flag) return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 0};
        int[] nums2 = {1, 5, 3, 2, 0};
        int[] nums3 = {1, 2, 3, 5, 4};
        int[] nums4 = {1, 4, 3, 2, 0};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber(nums2));
        System.out.println(missingNumber(nums3));
        System.out.println(missingNumber(nums4));
    }
}
