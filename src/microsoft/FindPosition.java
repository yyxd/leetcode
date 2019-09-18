package microsoft;

import java.util.Stack;

/**
 * Created by HinTi on 2019/9/7.
 * Goal: 找到某个数在数组中自己是最大值的区间[left,right]
 */
public class FindPosition {
    public static void findLeftRight(int[] origin) {
        int[] nums = new int[origin.length + 1];
        for (int i = 0; i < origin.length; i++)
            nums[i] = origin[i];
        nums[origin.length] = Integer.MAX_VALUE;
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int res = 0;
        int mod = 1000007;
        for (int i = 0; i < nums.length; i++) {
            while (stack.size() > 1 && nums[i] >= nums[stack.peek()]) {
                int mid = stack.pop();
                int l = mid - stack.peek() - 1, r = i - mid - 1;
                left[mid] = l;
                right[mid] = r;
                res = (res + nums[mid] * (l + r + l * r + 1) % mod) % mod;
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d %d %d \n", nums[i], left[i], right[i]);
        }
        System.out.println(res);
    }

    public static void brute(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            for (int j = i; j < nums.length; j++) {
                max = Math.max(nums[j], max);
                res += max;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 6, 8, 7, 2};
        findLeftRight(nums);
        brute(nums);
    }
}