package leetcode.array.easy;

/**
 * Created by Diane on 2017/6/1.
 */
public class leetcode376 {
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length<2) return nums.length;
        int ans = nums.length;
        int flag =0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==0) ans--;
            else if(nums[i]-nums[i-1]>0) {
                if(flag ==1)
                    ans--;
                else
                    flag=1;
            }
            else if(nums[i]-nums[i-1]<0){
                if(flag==-1)
                    ans--;
                else
                    flag=-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={0,0,1,1};
        System.out.print(wiggleMaxLength(nums));
    }
}
