package topGoogleQuestions;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by HinTi on 2019/9/26.
 * Goal: sliding window maximum
 */
public class Problem239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 0) return nums;
        if (k > nums.length) return new int[0];
        LinkedList<Integer> pos = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (!pos.isEmpty()) {
                int v = nums[pos.getLast()];
                if (v <= cur)
                    pos.removeLast();
                else
                    break;
            }
            pos.add(i);
            int windowFront = i + 1 - k;
            while (!pos.isEmpty() && pos.getFirst() < windowFront) {
                pos.removeFirst();
            }
            if (i >= k - 1)
                ans[i - k + 1] = nums[pos.getFirst()];
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        maxSlidingWindow(nums, k);
    }
}