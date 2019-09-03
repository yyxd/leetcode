package leetcode.cn.interview_problem.sort_search;

/**
 * Created by Diane on 2019-09-03.
 * Goal: 找到第K大的数
 */
public class FindKthLargest {
    // 找到第K大的数
    public int findK(int k, int[] nums) {
        if (k < 0 || k > nums.length) return -1;
        int target = nums.length - k;
        int s = 0, e = nums.length - 1;
        int p = -1;
        while (p != target) {
            p = partition(s, e, nums);
            if (p < target) s = p + 1;
            else e = p - 1;
        }
        return nums[p];
    }

    public void quickSort(int[] nums) {
        int s = 0, e = nums.length - 1;
        quickSort(s, e, nums);
    }

    public void quickSort(int s, int e, int[] nums) {
        if (s >= e) return;
        int mid = partition(s, e, nums);
        quickSort(s, mid - 1, nums);
        quickSort(mid + 1, e, nums);
    }

    public int partition(int s, int e, int[] nums) {
        int pivotal = nums[e];
        int k = s;
        for (int i = s; i <= e; i++) {
            if (nums[i] < pivotal) {
                swap(i, k, nums);
                k++;
            }
        }
        nums[e] = nums[k];
        nums[k] = pivotal;
        return k;
    }

    public void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 1, 3, 5, 7};
        FindKthLargest findk = new FindKthLargest();
        System.out.println(findk.findK(1,nums));
        System.out.println(findk.findK(2,nums));
        System.out.println(findk.findK(3,nums));
        System.out.println(findk.findK(4,nums));
//        findk.quickSort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.printf("%d ", nums[i]);
//        }
        System.out.println();
    }
}
