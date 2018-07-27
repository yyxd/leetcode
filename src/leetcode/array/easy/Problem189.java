package leetcode.array.easy;

/**
 * Created by Diane on 2017/11/21.
 */
public class Problem189 {
    /**
     * step 1 reverse原来的数组
     * step 2 reverse 0~ k-1
     * step 3 reverse k ~ n-1
     *
     * @param nums 数组
     * @param k    旋转步长
     */
    public static void rotate(int[] nums, int k) {
        k = (k % nums.length + nums.length) % nums.length;//保证k为正数，且属于0~k-1
        int temp;
        for (int i = 0; i < (nums.length / 2); i++) {
            temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        for (int i = 0; i < (k / 2); i++) {
            temp = nums[i];
            nums[i] = nums[k - 1 - i];
            nums[k - 1 - i] = temp;
        }

        for (int i = k; i <(nums.length-k)/2+k; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length - 1 - i + k];
            nums[nums.length - 1 - i + k] = temp;
        }

        for (int i = 0; i < nums.length - 1; i++)
            System.out.print(nums[i] + ", ");
        System.out.println(nums[nums.length - 1]);
    }

    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[k];
        for (int i = nums.length - k, j = 0; i < nums.length; i++, j++) {
            temp[j] = nums[i];
        }
        for (int i = nums.length - 1, j = 0; i > k; i++, j++) {
            nums[i] = nums[j];
        }
        for (int i = 0; i < k; i++)
            nums[i] = temp[i];

        for (int i = 0; i < nums.length - 1; i++)
            System.out.print(nums[i] + ", ");
        System.out.println(nums[nums.length - 1]);
    }

    public static void main(String[] args) {
        int[] nums0 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums4 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums5 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums6 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums7 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums8 = {1, 2, 3, 4, 5, 6, 7};

        rotate(nums0, 0);
        rotate(nums1, 1);
        rotate(nums2, 2);
        rotate(nums3, 3);
        rotate(nums4, 4);
        rotate(nums5, 5);
        rotate(nums6, 6);
        rotate(nums7, 7);
        rotate(nums8, 8);

    }
}
