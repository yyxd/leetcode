package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Diane on 2017/11/21.
 */
public class Problem219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> hashMap =new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                if((i-hashMap.get(nums[i]))<=k) return true;
                else
                    hashMap.put(nums[i],i);
            }
            hashMap.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,2,5,9,0};
        int k=3;
        System.out.println(containsNearbyDuplicate(nums,k));
    }
}
