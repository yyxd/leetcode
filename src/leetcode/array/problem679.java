package leetcode.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by hh23485 on 2017/10/19.
 */
public class problem679 {
    public static int findShortestSubArray(int[] nums) {
        int [] result = new int[50001];
        for(int num :result){
            num = 0;
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            result[nums[i]]++;
            if(result[nums[i]]>max)
                max = result[nums[i]];
        }
        int minLength = 50001;
        for(int i=0;i<result.length;i++){
            int firstIndex = 0;
            int lastIndex = 0;
            if(result[i] == max){
                for (int j=0;j<nums.length;j++)
                    if (nums[j]==i) { firstIndex = j; break;}
                for(int j = nums.length-1;j>=0;j--)
                    if (nums[j] == i) { lastIndex = j; break;}
                if(minLength>(lastIndex-firstIndex)) minLength = lastIndex-firstIndex;
            }
        }
        return minLength+1;
    }

    public static void main(String[] args) {
        int []nums = {1,2,2,3,1};
        System.out.println(findShortestSubArray( nums));
        int []nums2 = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray( nums2));
    }
}
