package leetcode.cn.interview_problem.string_problem;

import java.util.Arrays;

/**
 * Created by HinTi on 2019/5/31.
 * Goal: 字母异位词
 * 解法：一个是将字符串char排序
 * 另外是统计字符出现的频率，然后进行比较
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        int len = sArray.length;
        for(int i=0;i<len;i++){
            if(sArray[i]!=tArray[i])
                return false;
        }
        return true;
    }
    public boolean anotherAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int []stimes = new int[26];
        int []ttimes = new int[26];
        for(int i=0;i<s.length();i++){
            int index = s.charAt(i)-'a';
            stimes[index]++;
        }
        for(int i=0;i<t.length();i++){
            int index = t.charAt(i)-'a';
            ttimes[index]++;
        }
        for(int i=0;i<stimes.length;i++){
            if(stimes[i]!=ttimes[i])
                return false;
        }
        return true;
    }
}
