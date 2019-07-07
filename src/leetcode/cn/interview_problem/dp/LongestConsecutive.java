package leetcode.cn.interview_problem.dp;

import java.util.HashSet;

/**
 * Created by Diane on 2019-07-06.
 * Goal: 最长连续序列
 *
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int max = 0;
        for(int v:set){
            int curConsecutive = 0;
            if(!set.contains(v-1)){
                while (set.contains(v++)){
                    curConsecutive++;
                }
                max = Math.max(max, curConsecutive);
            }
        }
        return max;
    }
}
