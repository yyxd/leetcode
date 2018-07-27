package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Diane on 2017/12/28.
 * leetcode problem 169. Majority Element
 */
public class Problem169 {
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        if (len<=0) return 0;
        if(len==1) return nums[0];
        for (int i=0;i<len;i++)
        {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                if(map.get(nums[i])>(len/2)) return nums[i];
            }

            else
                map.put(nums[i],1);
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int []nums = {1,1,2};
        System.out.println(majorityElement(nums));
        System.out.println(9/2);
    }
}
