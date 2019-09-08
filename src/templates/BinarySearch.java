package templates;

/**
 * Created by HinTi on 2019/8/25.
 * Goal:
 */
public class BinarySearch {
    // 找到第一个大于等于target的数,l 是第一个大于等于target的数的下标，l-1 是第一个小于target的数的下标
    public static int search2(int[] nums, int target) {
        int len = nums.length;
        if (target > nums[len - 1]) return -1;
        int l = 0, r = len - 1, mid;
        while (l < r) {
            mid = (l + r) >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return nums[l];
    }

    // 找到第一个小于等于target的数,
    public static int search(int[] nums, int target) {
        int len = nums.length;
        if (target < nums[0]) return -1;
        int l = 0, r = len - 1, mid;
        while (l < r) {
            mid = (l + r + 1) >> 1;
            if (nums[mid] > target) r = mid - 1;
            else l = mid;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        System.out.println(0 + " " + search(nums, 0));
        System.out.println(1 + " " + search(nums, 1));
        System.out.println(3 + " " + search(nums, 3));
        System.out.println(4 + " " + search(nums, 4));
        System.out.println(11 + " " + search(nums, 11));
        System.out.println(12 + " " + search(nums, 12));
        System.out.println(13 + " " + search(nums, 13));
        System.out.println(15 + " " + search(nums, 15));
    }
}
