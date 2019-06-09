package leetcode.cn.interview_problem.array_problem;

/**
 * Created by Diane on 2019-06-09.
 * Goal: 递增的三元组 目前的想法是给两个指针，指向头，尾，满足，nums[头]<nums[尾】 如果没有符合的中 满足 nums[头]<nums[中]<nums[尾]
 */
public class IncreasingTriplet {
    public static boolean increasingTriplet(int[] nums) {
        int s =0,e =nums.length-1;
        return recurse(nums,s,e);
    }

    public static boolean recurse(int[] nums,int s,int e){
        if(e<0||s>=nums.length||s>=e) return false;
        while (s+1<nums.length&&nums[s]>=nums[s+1]){
            s++;
        }
        while (e-1>=0&&nums[e]<=nums[e-1]){
            e--;
        }
        if(s<e&&nums[s]<nums[e]){
            for(int i=s+1;i<e;i++){
                if (nums[i]<nums[e] && nums[i]>nums[s])return true;
            }
        }
        return (recurse(nums,s+1,e) || recurse(nums,s,e-1)) ;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,0,3};
        System.out.println(increasingTriplet(nums));
//        int[] nums2 = {3,4,1,2,5};
//        int[] nums3 = {1,6,5,4,2};
//        int[] nums4 = {6,7,8,5,4,6,8};
//        System.out.println(increasingTriplet(nums2));
//        System.out.println(increasingTriplet(nums3));
//        System.out.println(increasingTriplet(nums4));
    }
}
