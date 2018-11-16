package acwing.leetcode4;

/**
 * Created by HinTi on 2018/11/13.
 */
public class Problem14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<=0) return "";
        String ans = strs[0];
        for (int i=1;i<strs.length;i++) {
            ans = CommonPrefix(ans, strs[i]);
            if(ans == "") return ans;
        }
        return ans;
    }

    public String CommonPrefix(String s1, String s2) {
        int len = s1.length() < s2.length() ? s1.length() : s2.length();
        String res = "";
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i))
                res = res+s1.charAt(i);
            else
                return res;
        }
        return res;
    }

    public static void main(String[] args) {
        String strs[] = {"flower","flow","flight"};
        Problem14 problem14 = new Problem14();
        String ans = problem14.longestCommonPrefix(strs);
        System.out.println(ans);
        String strs2[] = {"dog","racecar","car"};
        ans = problem14.longestCommonPrefix(strs2);
        System.out.println(ans);
        String strs3[] = {"flower","flow"};
        ans = problem14.longestCommonPrefix(strs3);
        System.out.println(ans);
    }
}
