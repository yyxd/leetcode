package leetcode.array.mediunm;

/**
 * Created by HinTi on 2018/7/24.
 */
public class Problem34 {
    public static int[] searchRange(int[] nums,int target)
    {
        int [] ans = {-1,-1};
        int start = 0,end = nums.length-1,middle = 0;
        while (start<=end)
        {
            middle = (start+end)/2;
            if(nums[middle]==target) {
                if(middle==0||nums[middle-1]<target)
                {
                    ans[0]=middle;
                    break;
                }
                end = middle-1;
            }
            else if(target>nums[middle]) start =middle+1;
            else if(target<nums[middle]) end = middle-1;
        }
        start = 0; end = nums.length-1;
        while (start<=end)
        {
            middle =(start+end)/2;
            if(nums[middle]== target){
                if(middle==nums.length-1||nums[middle+1]>target){
                    ans[1] = middle;break;
                }
                start = middle+1;
            }
            else if(target>nums[middle]) start =middle+1;
            else if(target<nums[middle]) end = middle-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int []nums ={1,1,1,2,2,2,3,4,6};
        int [] ans = searchRange(nums,3);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
