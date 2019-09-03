package leetcode.cn.interview_problem.sort_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Diane on 2019-09-03.
 * Goal:
 */
public class MaxNumber {
    public static String largestNumber(int[] nums) {
        Comparator<Integer> numSort = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString();
                String s2 = o2.toString();
                return -(s1 + s2).compareTo((s2 + s1));
            }
        };
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list, numSort);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            ans.append(list.get(i));
        }
        int start = 0;
        while (start < ans.length() && ans.charAt(start) == '0') {
            start++;
        }
        if (start == ans.length())
            start--;
        return ans.toString().substring(start, ans.length());
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        System.out.println(largestNumber(nums));
    }
}
