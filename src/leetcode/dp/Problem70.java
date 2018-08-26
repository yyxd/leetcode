package leetcode.dp;

/**
 * Created by HinTi on 2018/8/24.
 * Climbing stairs
 * 状态转移方程：f(n)=f(n-1)+f(n-2)
 */
public class Problem70 {
    public int climbStairs(int n) {
        int k = 0,l = 1, ans = 1;
        for(int i = 1;i<=n;i++)
        {
            ans = k+l;
            k = l;
            l = ans;
        }
        return ans;
    }
}
