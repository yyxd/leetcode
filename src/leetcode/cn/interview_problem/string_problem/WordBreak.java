package leetcode.cn.interview_problem.string_problem;

import java.util.List;

/**
 * Created by HinTi on 2019/5/30.
 * Goal: 利用动态规划来解决单词拆分的问题
 * dp[i][j] = true if (dp[i][k] ==true and dp[k+1][j] == true)
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = isWordDictContains(i, i, s, wordDict);
        }
        for (int len = 1; len < s.length(); len++) {
            for (int i = 0; i < s.length()-len; i++) {
                if (isWordDictContains(i, i + len, s, wordDict))
                    dp[i][i + len] = true;
                else {
                    for (int k = i; k < i + len; k++) {
                        if (dp[i][k] && dp[k + 1][i + len])
                        {
                            dp[i][i + len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][s.length()-1];
    }

    /**
     * 其实动态规划的状态方程可以转化为dp[i] = dp[j] && wordDict.contains(s.substring(j,i))
     * 初始状态为dp[0] = true, 返回dp[s.length()]即可，dp[i]表示 s中以i-1为结尾的字符串是否可以被wordDict拆分
     * @param s
     * @param wordDict
     * @return
     */
    public boolean anotherWordBreak(String s, List<String> wordDict){
        boolean[] ans =new boolean[s.length()+1];
        ans[0] = true;
        for(int i=1;i<=s.length() ;i++){
            for(int j=0;j<i;j++)
                if(ans[j]&&wordDict.contains(s.substring(j,i)))
                    ans[i] = true;
        }
        return ans[s.length()];
    }
    public boolean isWordDictContains(int i, int j, String s, List<String> wordDict) {
        String temp = s.substring(i, j + 1);
        return wordDict.contains(temp);
    }
}
