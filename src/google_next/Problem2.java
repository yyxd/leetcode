package google_next;

/**
 * Created by Diane on 2019-07-07.
 * Goal:
 */
public class Problem2 {
    public static void main(String[] args) {
        String A = "1A2B3C4D56";
        String B = "B1D23CA45B6A";
        System.out.println(findLCS(A, A.length(), B, B.length()));
    }

    public static int findLCS(String A, int n, String B, int m) {
        if(n==0||m==0) return 0;
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;
        for(int i=1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
