package contest141;

/**
 * Created by Diane on 2019-06-16.
 * Goal:
 */

public class Problem4 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1=str1.length(),len2=str2.length();
        int[][] dp=new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=len1,j=len2;i>0||j>0;){
            if(i<=0){
                sb.append(str2.charAt(--j));
            }else if(j<=0){
                sb.append(str1.charAt(--i));
            }else if(dp[i][j]>dp[i-1][j]&&dp[i][j]>dp[i][j-1]){
                sb.append(str1.charAt(--i));
                --j;
            }else if(dp[i][j]>dp[i-1][j]){
                sb.append(str2.charAt(--j));
            }else{
                sb.append(str1.charAt(--i));
            }
        }
        return sb.reverse().toString();
    }
}
