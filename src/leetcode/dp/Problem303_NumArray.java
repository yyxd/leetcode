package leetcode.dp;

/**
 * Created by HinTi on 2018/8/25.
 */
public class Problem303_NumArray {
    private int []data;
    public Problem303_NumArray(int[] nums)
    {
        for (int i=1;i<nums.length;i++)
            nums[i] = nums[i-1]+nums[i];
        data = nums;
    }

    public int sumRange(int i,int j)
    {
        if(i<=0) return data[j];
        return data[j]-data[i-1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Problem303_NumArray obj = new Problem303_NumArray(nums);
        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(2,5));
        System.out.println(obj.sumRange(0,5));
    }
}
