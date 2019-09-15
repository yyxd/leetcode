package contest.contest154;

import java.util.HashMap;

/**
 * Created by HinTi on 2019/9/15.
 * Goal:
 */
public class ProblemA {
    public static int maxNumberOfBalloons(String text) {
        String key = "balloon";
        HashMap<Character, Integer> times = new HashMap<Character, Integer>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            times.put(ch, times.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> charset = new HashMap<>();
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            charset.put(ch, charset.getOrDefault(ch, 0) + 1);
        }
        int ans = Integer.MAX_VALUE;
        for (char ch : charset.keySet()) {
            int val = times.getOrDefault(ch, 0) / charset.get(ch);
            ans = Math.min(ans, val);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "nlaebolko";
        String s2 = "loonbalxballpoon";
        String s3 = "leetcode";
        System.out.println(maxNumberOfBalloons(s1));
        System.out.println(maxNumberOfBalloons(s2));
        System.out.println(maxNumberOfBalloons(s3));
    }
}