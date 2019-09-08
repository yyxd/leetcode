package google_next;

import java.util.Stack;

/**
 * Created by Diane on 2019-07-07.
 * Goal:
 */
public class Problem1 {
    public static boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = A.charAt(i);
            if(ch=='('||ch==')'){
                if(ch=='(')
                    stack.push(ch);
                else {
                    if(stack.size()==0)
                        return false;
                    else {
                        if(stack.pop()!='(')
                            return false;
                    }
                }
            }
            else
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test1 = "(";
        String test2 = "))))";
        String test3 = "";
        String test4 = "()()((()))";
        String test5 = "(a)";
        System.out.println(chkParenthesis(test1,test1.length()));
        System.out.println(chkParenthesis(test2,test2.length()));
        System.out.println(chkParenthesis(test3,test3.length()));
        System.out.println(chkParenthesis(test4,test4.length()));
        System.out.println(chkParenthesis(test5,test5.length()));
    }
}
