package leetcode;

/**
 * Created by hh23485 on 2017/10/31.
 */
public class Problem674 {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length ==0) return 0;
        int ans = 1,temp=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1]){
                temp++;
                if(temp>ans) ans = temp;
            }
            else{
                temp = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2};
        System.out.println(findLengthOfLCIS(nums));
        int[] nums2 = {1,3,5,7};
        System.out.println(findLengthOfLCIS(nums2));
        int[] nums3 = {};
        System.out.println(findLengthOfLCIS(nums3));
        int[] nums4 = {1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums4));
    }
}
