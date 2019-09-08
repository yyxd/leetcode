package google.next.week4;

/**
 * Created by HinTi on 2019/7/23.
 * Goal: leetcode problem 45
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int[] steps = new int[nums.length];// 到达第i个位置时需要多少步
        steps[0] = 0;
        for(int i=1;i<nums.length;i++)
            steps[i] = -1;
        for(int i=0;i<nums.length;i++){
            // 剪枝，当后一个数小于前一个数时，那么从前一个数跨越过去的step 一个比从后一个数跨越的要大
            if(i>=1&&nums[i]<nums[i-1]) continue;
            for(int j=i+1;j<nums.length&&j<=i+nums[i];j++){
                if(steps[j]==-1)
                    steps[j] = steps[i]+1;
                else {
                    steps[j] = Math.min(steps[j],steps[i]+1);
                }
            }
        }
        for (int i = 0; i < steps.length; i++) {
            System.out.print(steps[i]+"\t");
        }
        return steps[nums.length-1];
    }

    public static void main(String[] args) {
        JumpGameII jumpGame = new JumpGameII();
        int[] nums = {2,3,1,1,4};
        jumpGame.jump(nums);
    }
}