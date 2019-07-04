package leetcode.cn.interview_problem.stack_problem;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by HinTi on 2019/6/21.
 * Goal: 基本计算器II
 */
public class BasicCalculator {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                i++;
                continue;
            }
            if (ch == '*' || ch == '/') {
                i++;
                int next = 0, pre = 0;
                while (i<s.length()&&(( s.charAt(i) <= '9' && s.charAt(i) >= '0')||s.charAt(i)==' '))
                {
                    if(s.charAt(i)==' ') {
                        i++;
                        continue;
                    }
                    next = next * 10 + (s.charAt(i++) - '0');
                }
                pre = stack.pop();
                int ans = 0;
                if (ch == '*') ans = pre * next;
                else ans = pre / next;
                stack.push(ans);
            }else if(ch=='-') {
                stack.push(-1);
                i++;
            }
            else if(ch=='+') {
                stack.push(-2);
                i++;
            }
            else {
                int next =0;
                while (i<s.length() && ((s.charAt(i) <= '9' && s.charAt(i) >= '0')||s.charAt(i)==' ')){
                    if(s.charAt(i)==' ') {
                        i++;
                        continue;
                    }
                    next = next * 10 + (s.charAt(i++) - '0');
                }
                stack.push(next);
            }
        }
        int ans = 0;
        while (!stack.isEmpty()){
            int last = stack.pop();
            int op = stack.isEmpty()?-2:stack.pop();
            if(op==-1){//-
                ans = ans - last;
            }else if(op==-2){//+
                ans = ans+last;
            }
        }
        return ans;
    }
    // 学一学别人的代码怎么写的，我真菜
    public static int anotherCalculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char op ='+';
        int num =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c))
                num = num*10+c-'0';
            if(c<'0'&& c!=' '||i==s.length()-1){// 当字符为‘+’，‘-’，‘*’，‘/’，或者为‘ ’ 或者到达字符串末尾代表数字结束了
                if(op == '+') stack.push(num);
                if(op=='-') stack.push(-num);
                if(op=='*'||op=='/'){
                    int temp = stack.pop();
                    stack.push(op=='*'?temp*num:temp/num);
                }
                num =0;
                op =c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res +=stack.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "3 + 5 / 2 * 10";
        System.out.println(calculate(s));
    }
}