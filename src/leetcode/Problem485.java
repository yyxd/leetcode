/**
 * Created by Diane on 2017/11/10.
 */
public class Problem485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int ans=0,count=0;
        for (int i:nums) {
            if(i==1) count++;
            else {
                ans = Math.max(count,ans);
                count = 0;
            }
        }
        return Math.max(ans,count);
    }

    public static void main(String[] args) {
        int []nums = {1,1,0,0,1,1,1,0,1,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
