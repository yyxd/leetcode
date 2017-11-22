package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diane on 2017/11/18.
 * Find All Duplicates in an Array
 */
public class Problem442 {
//    public static int[] getNums(int[] nums){
//        int i=0,temp;
//        while(i<nums.length){
//            if((nums[i]==i+1)||(nums[nums[i]-1]==nums[i])) {
//                i++;
//                if(i>=nums.length) break;
//            }
//            if(nums[i]!=i+1){
//                temp = nums[nums[i]-1];
//                nums[nums[i]-1]=nums[i];
//                nums[i]=temp;
//            }
//
//        }
//        return nums;
//    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
         int i=0,temp;
        while(i<nums.length) {
            if ((nums[i] == i + 1) || (nums[nums[i] - 1] == nums[i])) {
                i++;
                if (i >= nums.length) break;
            }
            if (nums[i] != i + 1) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1) if(!ans.contains(nums[j])) ans.add(nums[j]);
        }
        return ans;
    }
//    }

    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> ans = findDuplicates(nums);
        for (Integer n:ans){
            System.out.print(n+", ");
        }
    }

}
