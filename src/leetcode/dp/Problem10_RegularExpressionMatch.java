package leetcode.dp;

/**
 * Created by HinTi on 2019/9/16.
 * Goal: 实现 . 和 * 的匹配
 * 以前做过？用递归？
 */
public class Problem10_RegularExpressionMatch {
    public static boolean isMatch(String s, String p) {
        return isMatch(0, 0, s, p);
    }

    public static boolean isMatch(int si, int pi, String s, String p) {
        if (si == s.length() && pi == p.length()) return true;
        else if (pi == p.length()) return false;
        if(si>s.length()) return false;
        if (p.charAt(pi) == '.') {
            if (pi + 1 < p.length() && p.charAt(pi + 1) == '*')
                return isMatch(si, pi + 2, s, p) || isMatch(si + 1, pi, s, p);
            else {
                return isMatch(si + 1, pi + 1, s, p);
            }
        } else {
            if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                if (si < s.length() && s.charAt(si) != p.charAt(pi))
                    return isMatch(si, pi + 2, s, p);
                else
                    return isMatch(si, pi + 2, s, p) || isMatch(si + 1, pi, s, p);
            } else if (si < s.length() && s.charAt(si) == p.charAt(pi))
                return isMatch(si + 1, pi + 1, s, p);
            else
                return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = ".*c";
        System.out.println(isMatch(s1, s2));
    }

}
