package leetcode.dp;

import java.util.Arrays;

/**
 * Created by Diane on 2019/2/11.
 * Goal: 给定具有n个不同金额的硬币（硬币个数无限）coins[0...n-1]，给一个整数amount，是否给的硬币能正好达到整数，给出能组成整数最少需要的硬币个数
 * Solution: 设置一个数组A[0...amount],进行初始化A[0]=0;A[1...amount] = -1;保存的是当给定金额为i时，所需要的最少的硬币。
 * dp转移方程式为 A[k] = 1+min(A[k-coins[0],A[k-coins[1],....A[k-coins[n-1]).
 * 这里要注意的是判断是否有解
 */
public class Problem322_CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] ans = new int[amount+1];
        Arrays.sort(coins);
        ans[0] = 0;
        for(int i=1;i<=amount;i++)
        {
            ans[i] = -1;
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]&&ans[i-coins[j]]!=-1) {
                    if(ans[i]!=-1)
                        ans[i]=Math.min(ans[i],1+ans[i-coins[j]]);
                    else
                        ans[i] = 1+ans[i-coins[j]];
                }
            }
        }
        return ans[amount];
    }

    public static void main(String[] args) {
        int []coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }
}
