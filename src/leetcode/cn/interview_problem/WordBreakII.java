package leetcode.cn.interview_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HinTi on 2019/5/30.
 * Goal: 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 分析：所有可能的句子，让我想到了回溯.
 * 然后还是TLE了TaT,
 * 没通过的例子为
 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
 ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]

 一般呢，回溯过不了的话使用动态规划
 */
public class WordBreakII {
    List<String> ans = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(! wordBreak_check(s,wordDict)) return ans;
        StringBuilder stringBuilder = new StringBuilder();
        wordBreak(stringBuilder,0,s,wordDict);
        return ans;
    }

    public void wordBreak(StringBuilder curSB,int index,String s ,List<String> wordDict){
        if(index>=s.length())
            ans.add(new String(curSB.toString()));
        for(int i =index;i<s.length();i++){
            String tempString = s.substring(index,i+1);
            if(wordDict.contains(tempString)){
                int tempIndex = curSB.length();
                if(tempIndex!=0)
                    curSB.append(" ");
                curSB.append(tempString);
                wordBreak(curSB,i+1,s,wordDict);
                curSB.delete(tempIndex,curSB.length());
            }
        }
    }

    /**
     * 其实动态规划的状态方程可以转化为dp[i] = dp[j] && wordDict.contains(s.substring(j,i))
     * 初始状态为dp[0] = true, 返回dp[s.length()]即可，dp[i]表示 s中以i-1为结尾的字符串是否可以被wordDict拆分
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_check(String s, List<String> wordDict){
        boolean[] ans =new boolean[s.length()+1];
        ans[0] = true;
        for(int i=1;i<=s.length() ;i++){
            for(int j=0;j<i;j++)
                if(ans[j]&&wordDict.contains(s.substring(j,i)))
                    ans[i] = true;
        }
        return ans[s.length()];
    }

    public static void main(String[] args) {
        WordBreakII wb2 = new WordBreakII();
    }

    /**
     * 有一个想法应该能实现，就是将这个转化成一个图论的内容
     * dp[i][j],如果 wordDict中含有这个s.substring(i,j+1)，可以认为i-j存在一个有向边，通过双层遍历，找到所有的边
     * 然后获取从0-s.length()-1的所有路径即可
     * 这种方法是不需要递归的，但是现在图论的内容有一点薄弱，暂时没办法实现
     * @param s
     * @param wordDict
     */
    public void anotherWordBreakII(String s,List<String> wordDict){

    }
}
