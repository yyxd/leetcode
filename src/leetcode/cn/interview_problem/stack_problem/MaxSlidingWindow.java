package leetcode.cn.interview_problem.stack_problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Diane on 2019-06-20.
 * Goal: 求滑动窗口的最大值
 * Solution: 双端队列
 */
public class MaxSlidingWindow {

    public static int[] anotherMaxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 0 || k <= 1) return nums;
        int max = findMax(0, k - 1, nums);
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0, j = k; j < nums.length; i++, j++) {
            ans[i] = max;
            if (nums[i] == max) {
                max = findMax(i + 1, j, nums);
            } else if (nums[j] > max) {
                max = nums[j];
            }
        }
        ans[ans.length - 1] = max;
        return ans;

    }

    public static int findMax(int i, int j, int[] nums) {
        int max = nums[i];
        for (int n = i + 1; n <= j; n++) {
            max = Math.max(nums[n], max);
        }
        return max;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 0 || k <= 1) return nums;
        List<Integer> ans = new ArrayList<>();
        LinkedList<Integer> windows = new LinkedList<>(); // 双端队列
        for (int i = 0; i < k - 1; i++) {
            while (windows.size() > 0 && nums[windows.peekLast()] < nums[i]) {
                windows.pollLast();
            }
            windows.offer(i);
        }
        for (int i = k - 1; i < nums.length; i++) {
            while (windows.size() > 0 && windows.peekFirst() <= i - k) {
                windows.pollFirst();
            }
            while (windows.size() > 0 && nums[windows.peekLast()] < nums[i]) {
                windows.pollLast();
            }
            windows.offer(i);
            ans.add(nums[windows.peekFirst()]);
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = anotherMaxSlidingWindow(nums, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
    }
}
