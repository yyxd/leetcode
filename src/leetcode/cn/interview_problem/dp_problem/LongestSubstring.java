package leetcode.cn.interview_problem.dp_problem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HinTi on 2019/7/4.
 * Goal: 找出最少有K个重复字符的子串
 */
public class LongestSubstring {
    public static int longestSubstring(String s, int k) {
        if(k<=1) return s.length();
        Map<Character,Integer> upperK = new HashMap<>();
        Map<Character,Integer> lowerK = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(upperK.containsKey(ch)) {
                upperK.put(ch,upperK.get(ch)+1);
            }else if(lowerK.containsKey(ch)){
                int times = lowerK.get(ch)+1;
                if(times>=k) {
                    lowerK.remove(ch);
                    upperK.put(ch,times);
                }else {
                    lowerK.put(ch,times);
                }

            }else {
                lowerK.put(ch,1);
            }
        }
        if(lowerK.size()==0) return s.length();
        if(upperK.size()==0) return 0;
        int i=0;
        while (!lowerK.containsKey(s.charAt(i))){
            i++;
        }
        int j = s.length()-1;
        while (!lowerK.containsKey(s.charAt(j))){
            j--;
        }
        int ans = longestSubstring( s.substring(0,i),k);
        if(j>i+1) {
            ans = Math.max(ans, longestSubstring(s.substring(i + 1, j), k));
        }
        ans = Math.max(ans,longestSubstring(s.substring(j+1,s.length()),k));
        return ans;
    }

    public static void main(String[] args) {
        String s = "abacad";
        int a = longestSubstring(s,2);
        System.out.println(a);
    }
}