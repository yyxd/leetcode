package leetcode.array.easy;

/**
 * Created by Diane on 2017/11/22.
 */
public class Problem26 {
    public static int removeDuplicates(int[] nums) {
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]) {
                nums[count] =nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int []nums = {1,1,2,3,4,4,5,5,5,5,5,6};
        System.out.println(removeDuplicates(nums));
    }
}
