package leetcode.cn.interview_problem.array_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Diane on 2019-06-09.
 * Goal: 求两个数组的交集
 * Solution: 使用hashtable存储元素及其出现的次数
 */
public class IntersectOf2Arrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int key : map1.keySet()) {
            int times = Math.min(map1.getOrDefault(key,0), map2.getOrDefault(key,0));
            for (int i = 0; i < times; i++) {
                ans.add(key);
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public static int[] anotherIntersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else{
                j++;
            }
        }
        int[] result = new int[ans.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = ans.get(k);
        }
        return result;
    }

    public static void main(String[] args) {
        int nums1[] = {4,4,9,5};
        int nums2[] = {4,9,9,4,6,4};
        int[] ans = anotherIntersect(nums1,nums2);
        for (int an : ans) {
            System.out.print(an+"\t");
        }
    }
}
