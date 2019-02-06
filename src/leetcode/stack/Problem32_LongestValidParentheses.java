package leetcode.stack;

import java.util.Stack;

/**
 * Created by Diane on 2019/2/6.
 * Goal: 最长有效子串 给定一组仅包含(,)的字符串，判断其中最长的有效子串的长度
 */
public class Problem32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') stack.push(i);
            else {
                stack.pop();
                if(stack.isEmpty()){
                   stack.push(i);
                }else {
                   ans = Math.max(ans,i-stack.peek());
                }
            }
        }
        return ans;
    }
}
