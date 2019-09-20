package google;

import java.util.Stack;

/**
 * Created by HinTi on 2019/9/19.
 * Goal:
 */
public class Problem32 {
    public int longestValidParentheses(String s) {
        if (s.length() <= 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int front = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                stack.push(i);
            else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    int pre = stack.isEmpty() ? front : stack.peek();
                    ans = Math.max(ans, i - pre);
                } else {
                    front = i;
                }
            }
        }
        return ans;
    }
}