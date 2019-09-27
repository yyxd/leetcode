package topGoogleQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by HinTi on 2019/9/25.
 * Goal: rotated 180 degrees
 */
public class Problem247_StrobogrammaticII {
    List<StringBuilder> res = new ArrayList<>();

    public List<String> findStrobogrammatic(int n) {
        res.clear();
        int k = n / 2;
        List<String> ans = new ArrayList<>();
        StringBuilder param = new StringBuilder();
        generateStrings(param, k);
        if ((n & 1) == 1) {//odd number
            char[] mid = {'0', '1', '8'};
            for (int i = 0; i < 3; i++) {
                for (StringBuilder curStr : res) {
                    StringBuilder newStr = new StringBuilder(curStr);
                    newStr.append(mid[i]);
                    newStr.append(getRotated(curStr.toString()));
                    ans.add(newStr.toString());
                }
            }
        } else {
            for (StringBuilder curStr : res) {
                curStr.append(getRotated(curStr.toString()));
                ans.add(curStr.toString());
            }
        }
        Collections.sort(ans);
        System.out.println(Arrays.toString(ans.toArray()));
        return ans;
    }


    List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("1", "0", "8"));
        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != m) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("8" + s + "8");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
        }
        return res;
    }

    public String getRotated(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '1' || ch == '0' || ch == '8')
                ans.append(ch);
            else if (ch == '6')
                ans.append('9');
            else
                ans.append('6');
        }
        return ans.toString();
    }

    public void generateStrings(StringBuilder curStr, int len) {
        if (curStr.length() >= len) {
            res.add(curStr);
            return;
        }
        char[] start = {'1', '8', '6', '9'};
        char[] all = {'1', '8', '0', '6', '9'};
        if (curStr.length() == 0) {
            all = start;
        }
        for (int i = 0; i < all.length; i++) {
            StringBuilder newStr = new StringBuilder(curStr);
            newStr.append(all[i]);
            generateStrings(newStr, len);
        }
    }

    public static void main(String[] args) {
        Problem247_StrobogrammaticII problem247 = new Problem247_StrobogrammaticII();
        problem247.findStrobogrammatic(2);
        problem247.findStrobogrammatic(1);
        problem247.findStrobogrammatic(3);
    }
}