package leetcode;

/**
 * Created by Diane on 2017/11/23.
 */
public class Problem66 {
    public static int[] plusOne(int[] digits) {
        int []ans = new int[digits.length];
        int flag = 1;
        int temp ;
        for (int i=digits.length-1;i>=0;i--)
        {
            temp = flag+digits[i];
            if (temp==10){
                flag = 1;
                ans[i] = 0;
            }
            else {
                flag = 0;
                ans[i] = temp;
            }
        }
        if (ans[0]==0){
            int[] realAns = new int[digits.length+1];
            for (int i=1;i<=digits.length;i++)
                realAns[i]=ans[i-1];
            realAns[0] = 1;
            return realAns;
        }
        return ans;
    }

    public static void printArray(int[] nums) {
        for (int i=0;i<nums.length-1;i++)
            System.out.print(nums[i]+", ");
        System.out.println(nums[nums.length-1]);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,9};
        int[] nums2 = {9,9,9,9};
        printArray(plusOne(nums));
        printArray(plusOne(nums2));
    }
}
