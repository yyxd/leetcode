package leetcode.cn.interview_problem.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diane on 2019-07-04.
 * Goal: 求最长的上升序列
 * 以当前的数结尾的最长的上升序列
 */
public class LengthofLIS {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length <= 0) return 0;
        int[] dp = new int[nums.length + 1];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int lengthOfLIS_greedy(int[] nums) {
        if (nums.length<=1) return nums.length;
        List<Integer> tail = new ArrayList<>();
        tail.add(nums[0]);
        for(int i =1;i<nums.length;i++){
            if(nums[i]>tail.get(tail.size()-1))
                tail.add(nums[i]);
            else {
                int index = find(tail, nums[i]);
                if(index!=-1)
                    tail.set(index, nums[i]);
            }
            for(int n:tail){
                System.out.print(n+"\t");
            }
            System.out.println();
        }
        for(int n:tail){
            System.out.print(n+"\t");
        }
        System.out.println();
        return tail.size();
    }

    /**
     * 二分搜索，找到array中第一个大于target的数
     *
     * @param array  数组
     * @param target target
     * @return 第一个大于target 的位置
     */
    public static int find(List<Integer> array, int target) {
        int low = 0, high = array.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array.get(mid) <= target) {
                low = mid + 1;
            } else if (array.get(mid) > target && (mid - 1 < 0 || array.get(mid - 1) < target)) {
                return mid;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        System.out.println(lengthOfLIS_greedy(nums));
    }
}
