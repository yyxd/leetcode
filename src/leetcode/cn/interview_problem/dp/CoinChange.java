package leetcode.cn.interview_problem.dp;

/**
 * Created by Diane on 2019-07-06.
 * Goal: 零钱兑换，和numSquare 一样的思想
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        dp[0] =0;
        for(int i=1;i<=amount;i++){
            dp[i] = -1;
        }
        for(int i=1;i<=amount;i++){
            for (int j = 0; j < coins.length; j++) {
                if(i>=coins[j]){
                    int temp = dp[i-coins[j]];
                    if(temp!=-1) {
                        dp[i] = dp[i]==-1?temp + 1:Math.min(temp+1,dp[i]);
                    }
                }
            }
        }
        return dp[amount];
    }
}
