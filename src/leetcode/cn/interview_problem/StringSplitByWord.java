package leetcode.cn.interview_problem;

import java.util.List;

/**
 * Created by Diane on 2019-05-30.
 * Goal: 给定一个单词的字典，判断给定字符串能否被字典中的单词分割开
 * Solution: 动态规划，能通过的答案是利用动态规划做的。确实对于这种回溯问题的优化，要想到可不可以使用动态规划来做！
 * dp[i,j] = true
 *  if (dp[i,k] == true and dp[k+1,j] == true
 */
public class StringSplitByWord {
    /**
     * 是一个回溯问题，首先采用最小匹配，就是尽量匹配到短的，如果不行，在将字符串
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s,0,wordDict);
    }

    public boolean wordBreakByDP(String s, List<String> wordDict){
        // 错误原因，好像循环写的不对，明天再改，今晚睡觉啦
        boolean[][] dpStatus = new boolean[s.length()][s.length()];
        for(int i =0;i<s.length();i++){
            for(int j =i;j<s.length();j++)
                if(isInwordDict(s,i,j,wordDict))
                    dpStatus[i][j]=true;
                else
                    for(int k =i;k<j;k++){
                        if(dpStatus[i][k]&&dpStatus[k+1][j])
                            dpStatus[i][j] = true;
                    }
        }
        return dpStatus[0][s.length()-1];

    }

    public boolean wordBreak(String s,int index,List<String> wordDict){
        if(index>=s.length()) return true;
        int end = index;
        while (end<s.length()){
            if(isInwordDict(s,index,end,wordDict))
                if(wordBreak(s,end+1,wordDict))
                    return true;
            end++;
        }
        return false;
    }

    public boolean isInwordDict(String s,int i,int j,List<String> wordDict){
        String word = s.substring(i,j+1);
        if(wordDict.contains(word)) return true;
        return false;
    }
}
