package google.next.week4;

/**
 * Created by HinTi on 2019/7/24.
 * Goal: leetcode problem 392
 */
public class IsSubsequence {
    // t 很长， s 是个短字符串
    public boolean isSubsequence(String s, String t) {
        int j =0;
        if(s.length()==0) return true;
        if(t.length()==0) return false;
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(ch == s.charAt(j)){
                j++;
                if(j==s.length())
                    return true;
            }
        }
        return false;
    }
}