package leetcode.cn.interview_problem.hash_problem;

import java.util.HashMap;

/**
 * Created by HinTi on 2019/7/4.
 * Goal:
 */
public class TitleToNumber {
    public int titleToNumber(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int v = ch-'A'+ 1;
            ans = ans*26+v;
        }
        return ans;
    }
}