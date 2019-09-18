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
            if (nums[mid] >= target)
                r = mid;
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
            if (nums[l] <= target)
                l = mid;
            else
                r = mid - 1;
        }
        return nums[l];
    }

    // 找到从右往左第一个符合条件的元素
    static int binSearch_1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (check1(mid, target, nums))
                r = mid;
            else l = mid + 1;
        }
        if (check1(l, target, nums))
            return nums[l];
        return -1;
    }

    // 找到从左往右第一个符合条件的元素
    static int binSearch_2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (1 + l + r) / 2;
            if (check2(mid, target, nums))
                l = mid;
            else
                r = mid - 1;
        }
        if (check2(l, target, nums))
            return nums[l];
        return -1;
    }

    static boolean check1(int mid, int target, int[] nums) {
        if (nums[mid] >= target) return true;
        else return false;
    }

    static boolean check2(int mid, int target, int[] nums) {
        if (nums[mid] <= target) return true;
        else return false;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        // 大于等于该元素的第一个数
        System.out.println(0 + " " + binSearch_1(nums, 0));
        System.out.println(1 + " " + binSearch_1(nums, 1));
        System.out.println(3 + " " + binSearch_1(nums, 3));
        System.out.println(4 + " " + binSearch_1(nums, 4));
        System.out.println(11 + " " + binSearch_1(nums, 11));
        System.out.println(12 + " " + binSearch_1(nums, 12));
        System.out.println(13 + " " + binSearch_1(nums, 13));
        System.out.println(15 + " " + binSearch_1(nums, 15));

        // 小于等于该元素的第一个数
        System.out.println(0 + " " + binSearch_2(nums, 0));
        System.out.println(1 + " " + binSearch_2(nums, 1));
        System.out.println(3 + " " + binSearch_2(nums, 3));
        System.out.println(4 + " " + binSearch_2(nums, 4));
        System.out.println(11 + " " + binSearch_2(nums, 11));
        System.out.println(12 + " " + binSearch_2(nums, 12));
        System.out.println(13 + " " + binSearch_2(nums, 13));
        System.out.println(15 + " " + binSearch_2(nums, 15));
    }
}
