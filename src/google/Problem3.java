package google;

import com.sun.glass.ui.Size;

import java.util.HashMap;

/**
 * Created by HinTi on 2019/9/12.
 * Goal:
 */
public class Problem3 {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int ans = 0;
        int len = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hashMap.containsKey(ch)) {
                ans = Math.max(ans, len);
                start = Math.max(start,hashMap.get(ch));
                len = i - start;
                hashMap.put(ch, i);
            } else {
                hashMap.put(ch, i);
                len++;
            }
        }
        return Math.max(ans, len);
    }

    public static void main(String[] args) {
        String s ="abba";
        System.out.println(lengthOfLongestSubstring(s));
    }
}