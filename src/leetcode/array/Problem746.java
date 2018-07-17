package leetcode.array;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by HinTi on 2018/1/18.
 */
public class Problem746 {
    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length<=1)
            return 0;
        int [] f = new int[cost.length];
        f[0] = cost[0];
        f[1] = cost[1];
       for(int i=2;i<cost.length;i++)
           f[i] = cost[i] + Math.min(f[i-1],f[i-2]);
       return Math.min(f[cost.length-1],f[cost.length-2]);
    }

    public static void main(String[] args) {
        int []cost = {10,15,20};
        int []cost2 = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostClimbingStairs(cost2));
    }
}
