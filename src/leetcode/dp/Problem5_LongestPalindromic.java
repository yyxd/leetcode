package leetcode.dp;

/**
 * Created by Diane on 2019/4/17.
 * Goal: 最长回文子串
 * Solution1: 以字符串每一个字符为中心，求解是否有回文串，并计算回文子串的长度
 */
public class Problem5_LongestPalindromic {

    public String longestPalindrome(String s) {
        int ans = 0;
        String lps = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append('#');
        String news = sb.toString();
        for (int i = 0; i < news.length(); i++) {
            int left = i - 1, right = i + 1;
            int tempLen = 1;
            while (left >= 0 && right < news.length() && news.charAt(left) == news.charAt(right)) {
                tempLen++;
                left--;
                right++;
            }
            if (ans < tempLen) {
                ans = tempLen;
                lps = news.substring(left + 1, right);
            }
        }
        StringBuilder newsb = new StringBuilder();
        for (int i = 1; i < lps.length(); i = i + 2)
            newsb.append(lps.charAt(i));
        return newsb.toString();
    }

    public static void main(String[] args) {
        Problem5_LongestPalindromic solution = new Problem5_LongestPalindromic();
        System.out.println(solution.longestPalindrome("babaddas"));
        System.out.println(solution.longestPalindrome("bccaccd"));
    }
}
