package topGoogleQuestions;

import java.util.Stack;

/**
 * Created by HinTi on 2019/9/25.
 * Goal:Decode String
 */
public class Problem394 {
    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> count = new Stack<>();
        Stack<String> tmpStr = new Stack<>();
        int v = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9')
                v = v * 10 + ch - '0';
            else if (ch == '[') {
                count.push(v);
                tmpStr.push(res.toString());
                res.delete(0, res.length());
                v = 0;
            } else if (ch == ']') {
                StringBuilder cur = new StringBuilder(tmpStr.pop());
                int times = count.pop();
                for (int j = 0; j < times; j++)
                    cur.append(res);
                res = cur;
            } else
                res.append(ch);
        }

        return res.toString();

    }

    public static void main(String[] args) {
        String s = "3[a]2[b3[d]c]ef";
        System.out.println(decodeString(s));
    }
}