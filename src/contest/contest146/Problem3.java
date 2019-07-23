package contest.contest146;

/**
 * Created by Diane on 2019-07-21.
 * Goal:
 */
public class Problem3 {
    public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = 0;
//            dp[i][i + 1] = arr[i] * arr[i + 1];
        }
//        dp[arr.length - 1][arr.length - 1] = 0;

        for(int k = 1;k<arr.length;k++){
            for(int i=0;i<arr.length-k;i++)
            {
                int j = i+k;
                dp[i][j] = Integer.MAX_VALUE;
                for(int t =i;t<i+k;t++){
                    int temp = dp[i][t]+dp[t+1][j]+maxij(arr,i,t)*maxij(arr, t+1, j);
                    dp[i][j] = Math.min(temp, dp[i][j]);
                }
            }
        }
        return dp[0][arr.length-1];

    }

    public int maxij(int[] arr, int i, int j) {
        int maxValue = arr[i];
        for (int k = i + 1; k <= j; k++)
            maxValue = Math.max(maxValue, arr[k]);
        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = {7,12,8,10};
        Problem3 problem3 = new Problem3();
        int ans = problem3.mctFromLeafValues(arr);
        System.out.println(ans);
    }
}
