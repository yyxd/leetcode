package contest.contest154;

import java.util.Stack;

/**
 * Created by HinTi on 2019/9/15.
 * Goal:
 */

public class ProblemB {
    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                StringBuilder temp = new StringBuilder();
                while (true) {
                    char cur = stack.pop();
                    if (cur == '(')
                        break;
                    else
                        temp.append(cur);
                }
                if (stack.isEmpty())
                    ans.append(temp);
                else {
                    for (int j = 0; j < temp.length(); j++)
                        stack.push(temp.charAt(j));
                }
            } else {
                if (stack.isEmpty())
                    ans.append(ch);
                else
                    stack.push(ch);
            }

            i++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "ld(u(love)i)";
        System.out.println(reverseParentheses(s));
    }
}