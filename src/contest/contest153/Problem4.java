package contest.contest153;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Diane on 2019-09-08.
 * Goal: leetcode 5148
 */
public class Problem4 {
    // TODO 解决LeetCode 5148 的问题
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = new HashSet<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i : arr1)
            set1.add(i);
        for (int i : arr2) {
            if (!set1.contains(i))
                list2.add(i);
        }
        Collections.sort(list2);
        int step = 0;
        int[][] dp = new int[arr1.length][2];
        // 对于每一个数可以选择操作或者不操作


        // 两种情况，从前往后，数都选择尽可能变小

        // 从后往前，数选择尽可能变大


        return 0;
    }
}
