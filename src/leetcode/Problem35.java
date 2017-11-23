package leetcode;

/**
 * Created by Diane on 2017/11/23.
 */
public class Problem35 {
    public static int searchInsert(int[] nums, int target) {
        int i=0;
        while (i<nums.length&&nums[i]<target){
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int []nums={1,3,5,6};
        searchInsert(nums,5);
        searchInsert(nums,2);
        searchInsert(nums,7);
        searchInsert(nums,0);
    }
}
