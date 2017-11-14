package leetcode;

/**
 * Created by hh23485 on 2017/10/31.
 */
public class Problem643 {
    public static double findMaxAverage(int[] nums, int k) {
        double sum =0;
        for(int i=0;i<k;i++)
            sum+=nums[i];
        double ans = sum;
        for(int i=k;i<nums.length;i++){
            sum=sum-nums[i-k]+nums[i];
            if(sum>ans) ans = sum;
        }
        return ans/(double) k ;
    }

    public static void main(String[] args) {
        int []nums ={1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums,4));
    }
}
