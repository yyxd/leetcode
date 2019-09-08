package acmcoder.xiecheng;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Diane on 2019-09-04.
 * Goal:
 */

public class ProblemB {

    static boolean isLegal(String expr) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '(')
                stack.push(ch);
            else if (ch == ')') {
                if (stack.size() <= 0) return false;
                stack.pop();
            }
        }
        return stack.size() == 0;
    }

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        StringBuilder ans = new StringBuilder();
        if (!isLegal(expr)) return "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '(')
                stack.push(ch);
            else if (ch == ')') {
                StringBuilder temp = new StringBuilder();
                char t;
                while (!stack.empty()) {
                    t = stack.pop();
                    if (t == '(')
                        break;
                    else
                        temp.append(t);
                }
                if (stack.size() <= 0) ans.append(temp);
                else {
                    for (int j = 0; j < temp.length(); j++)
                        stack.push(temp.charAt(j));
                }
            } else {
                if(stack.size()<=0)
                    ans.append(ch);
                else
                stack.push(ch);
            }
        }
        return ans.toString();
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}

