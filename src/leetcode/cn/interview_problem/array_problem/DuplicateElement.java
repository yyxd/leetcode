package leetcode.cn.interview_problem.array_problem;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Diane on 2019-06-02.
 * Goal: 查找数组中是否存在重复元素
 * Solution：1. hashmap保存每一次的结果，O(n)
 * 2. 对数组进行排序，如果后一个等于前一个，那就return true
 */
public class DuplicateElement {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> freq = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(freq.contains(nums[i]))
                return true;
            freq.add(nums[i]);
        }
        return false;
    }
}
