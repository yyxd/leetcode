package topGoogleQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by HinTi on 2019/9/24.
 * Goal:
 */

public class Problem1 {
    // use binary search
    public int[] twoSum(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int newT = target - arr[i][0];
            int res = binSearch(arr, newT, i + 1);
            if (res != -1) {
                ans[0] = arr[i][1];
                ans[1] = res;
                return ans;
            }
        }
        return ans;
    }

    public int binSearch(int[][] nums, int target, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid][0] == target) return nums[mid][1];
            if (nums[mid][0] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // use hashmap to store elements' value and subscript ; use hash map then the find operation is O(1)
    public int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
                if (ans[0] != ans[1])
                    return ans;
            }
        }
        return ans;
    }

    // use two-pointers
    public int[] twoSum3(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] ans = new int[2];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = arr[left][0] + arr[right][0];
            if (sum == target) {
                ans[0] = arr[left][1];
                ans[1] = arr[right][1];
                return ans;
            } else if (sum < target)
                left++;
            else
                right--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        Problem1 problem1 = new Problem1();

        int[] ans = problem1.twoSum(nums, target);
        int[] ans2 = problem1.twoSum2(nums, target);
        int[] ans3 = problem1.twoSum3(nums, target);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(ans2));
        System.out.println(Arrays.toString(ans3));
    }


}