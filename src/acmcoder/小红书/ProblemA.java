package acmcoder.小红书;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Diane on 2019-09-03.
 * Goal:
 */
public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                stack.push(ch);
            else if (ch != ')') {
                if (stack.size() == 0 || stack.peek() != '(')
                    stack.push(ch);
            } else {
                stack.pop();
            }
        }
        while (stack.size() != 0) {
            stringBuilder.append(stack.pop());
        }
        stringBuilder = new StringBuilder(stringBuilder.reverse());
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < stringBuilder.length()) {
            char ch = stringBuilder.charAt(i);
            if (ch == '<') {
                if (ans.length() > 0)
                    ans.deleteCharAt(ans.length() - 1);
            } else
                ans.append(ch);
            i++;
        }
        System.out.println(ans.toString());
    }
}
