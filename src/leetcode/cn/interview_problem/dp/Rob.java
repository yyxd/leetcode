package leetcode.cn.interview_problem.dp;

/**
 * Created by Diane on 2019-07-04.
 * Goal:
 */
public class Rob {
    public int rob(int[] nums) {
        if(nums.length<=0) return 0;
        int[] rob = new int[nums.length+1];
        rob[0]=0;
        rob[1] = nums[0];
        for(int i=1;i<nums.length;i++){
            int j = i+1;
            rob[j] = Math.max(rob[j-1],rob[j-2]+nums[i]);
        }
        return rob[nums.length];
    }
}
