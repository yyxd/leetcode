package leetcode.array;

/**
 * Created by Diane on 2017/11/23.
 */
public class Problem27 {
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=val) {
                nums[count]=nums[i];
                count++;
            }
        }
//        for (int i=0;i<count-1;i++)
//            System.out.print(nums[i]+", ");
//        System.out.println(nums[count-1]);
        return count;
    }

    public static void main(String[] args) {
        int []nums = {3,2,2,3,5};
        int val = 3;
        removeElement(nums,val);
    }
}
