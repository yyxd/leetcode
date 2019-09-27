package topGoogleQuestions;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created by HinTi on 2019/9/24.
 * Goal:
 */
public class Problem560 {
    public int subarraySum(int[] nums, int k) {
        int[][] prefixSum = new int[nums.length + 1][2];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1][0] = prefixSum[i][0] + nums[i];
            prefixSum[i + 1][1] = i + 1;
        }
        Arrays.sort(prefixSum, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int ans = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            int cur = prefixSum[i][0];
            int curIndex = prefixSum[i][1];
            ans += getCountOfK(prefixSum, cur + k, curIndex);
        }
        return ans;
    }

    // use binary search
    // get the count of subarray's sum equal to target and the subArray's end index greater than the given index
    public int getCountOfK(@NotNull int[][] arr, int target, int curIndex) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid][0] >= target) right = mid;
            else
                left = mid + 1;
        }
        int count = 0;
        while (left < arr.length && arr[left][0] == target) {
            // only if the subArray's end Index greater than current index, that's a valid sub array
            if (arr[left][1] > curIndex)
                count++;
            left++;
        }
        return count;
    }

    // use hashMap to store the prefix sum and the find operation is O(1)

    public int subarraySum2(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        // key: sub array's sum ;value: a list of end index of subArray
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int pre = 0;
        List<Integer> endIndexes = new ArrayList<>();
        endIndexes.add(0);
        map.put(pre, endIndexes);
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = nums[i] + prefixSum[i];
            int cur = prefixSum[i + 1];
            if (!map.containsKey(cur)) {
                List<Integer> indexes = new ArrayList<>();
                map.put(cur, indexes);
            }
            map.get(cur).add(i + 1);
        }
        int ans = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            int target = k + prefixSum[i];
            if (map.containsKey(target)) {
                List<Integer> indexes = map.get(target);
                // find the first index greater than i
                ans += getCountBiggerThanK(indexes, i + 1);
            }
        }
        return ans;
    }

    public int getCountBiggerThanK(List<Integer> list, int k) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= k) right = mid;
            else
                left = mid + 1;
        }
        if (left < list.size() && list.get(left) < k)
            return 0;
        return list.size() - left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        Problem560 problem560 = new Problem560();
        System.out.println(problem560.subarraySum2(nums, 2));
    }
}