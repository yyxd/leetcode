package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diane on 2017/12/30.
 * 要考虑边界条件，如果index= 0后面的值加起来等于0
 * 或者没有任何相等的，但是，index = n-1前面的值加起来等于0的话
 * 这两种情况都要输出index
 */
public class Problem724 {
    public static int pivotIndex(int[] nums) {
        if(nums.length<1) return -1;
        int leftSum=0;
        List<Integer> rightSum = new ArrayList<>();
        int sumtemp = 0;
        rightSum.add(0);
        for(int i=nums.length-1;i>=0;i--) {
            sumtemp+=nums[i];
            rightSum.add(sumtemp);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(leftSum ==rightSum.get(nums.length-i-1))
                return i;
            leftSum+=nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int []array = {1, 7, 3, 6, 5, 6};
        int []array1 = {1,2,3};
        int []array2 = {1,4,9,5};
        int []array3 = {-1,-1,-1,0,1,1};
        int []array4 = {-1,-1,-1,0,1,1,1,3};
        System.out.println(pivotIndex(array));
        System.out.println(pivotIndex(array1));
        System.out.println(pivotIndex(array2));
        System.out.println(pivotIndex(array3));
        System.out.println(pivotIndex(array4));
    }
}
