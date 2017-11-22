package leetcode;

/**
 * Created by Diane on 2017/11/21.
 */
public class Problem283 {
    public static void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            j++;
            if(nums[i]==0){
                while (j<nums.length&&nums[j]==0)
                    j++;
                if(j>=nums.length) break;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int []nums={1,0,0,5,6,0,7};
        moveZeroes(nums);
    }
}
