package leetcode.stack;

import java.util.Stack;

/**
 * Created by Diane on 2019/2/6.
 * Goal:
 */
public class Problem150_EvlRPN {

    public static int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int v1 = 0, v2 = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                v2 = stack.pop();
                v1 = stack.pop();
                v1 = v1 + v2;
                stack.push(v1);
            } else if (tokens[i].equals("-") ){
                v2 = stack.pop();
                v1 = stack.pop();
                v1 = v1 - v2;
                stack.push(v1);
            } else if (tokens[i].equals("*") ){
                v2 = stack.pop();
                v1 = stack.pop();
                v1 = v1 * v2;
                stack.push(v1);
            } else if (tokens[i].equals("/") ){
                v2 = stack.pop();
                v1 = stack.pop();
                v1 = v1 / v2;
                stack.push(v1);
            } else {
                int v = transToInt(tokens[i]);
                stack.push(v);
            }
        }
        return stack.pop();
    }

    public static int transToInt(String s) {
        int ans = 0;
        int end = 0;
        boolean flag = true;
        if(s.charAt(0) == '-')
        {
            end = 1;
            flag = false;
        }else if(s.charAt(0)=='+'){
            end = -1;
            flag = true;
        }
        for (int i = end; i <s.length(); i++) {
            int t = s.charAt(i) - '0';
            ans = ans * 10 + t;
        }
        return flag?ans:-1*ans;
    }

    public static void main(String[] args) {
        String[] tokens = {};
        System.out.println(evalRPN(tokens));
    }
}
