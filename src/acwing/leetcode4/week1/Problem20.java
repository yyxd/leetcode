package acwing.leetcode4.week1;

import java.util.Stack;

/**
 * Created by HinTi on 2018/11/13.
 */
public class Problem20 {
    public boolean isValid(String s) {
        if(s.length()%2 !=0) return false;
        Stack<Character> chs = new Stack<Character>();
        char c,p;
        for(int i = 0;i<s.length();i++){
             c = s.charAt(i);
            if(c=='('||c=='{'||c=='[')
                chs.push(c);
            else if(c == ')') {
                if(chs.empty()||chs.pop() !='(')
                    return false;
            }else if(c=='}'){
                if(chs.empty()||chs.pop()!='{')
                    return false;
            }else if (chs.empty()||c==']')
                if(chs.pop()!='[')
                    return false;
        }
        if(chs.empty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s1="()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";
        String s6 = "{[]}(){}";
        Problem20 problem20 = new Problem20();
        System.out.println(problem20.isValid(s1));
        System.out.println(problem20.isValid(s2));
        System.out.println(problem20.isValid(s3));
        System.out.println(problem20.isValid(s4));
        System.out.println(problem20.isValid(s5));
        System.out.println(problem20.isValid(s6));
    }
}
