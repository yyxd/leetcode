package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Diane on 2017/12/28.
 * leetcode problem 167 Two Sum II - Input array is sorted
 */
public class Problem167 {
    public static void main(String[] args) {
        int[] array = {2, 3, 4};
        int target = 6;
        twoSum(array,target);

    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++)

            map.put(numbers[i], i + 1);
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (map.containsKey(temp)) {
                ans[0] = i + 1;
                ans[1] = map.get(temp);
                return ans;
            }

        }
        return ans;
    }


}
