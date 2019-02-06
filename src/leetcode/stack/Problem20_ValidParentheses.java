package leetcode.stack;

import java.util.Stack;

/**
 * Created by Diane on 2019/2/6.
 * Goal: 有效的括号 输入是包括{,},(,),[,]的数组，判断是否所有的括号都有匹配
 * Solution:使用栈来做，但要注意取出值时栈可能为空
 */
public class Problem20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c =='('||c =='{'||c=='[') stack.push(c);
            else if(c == ')'){
                if(stack.isEmpty()||stack.pop()!='(') return false;
            }else if(c==']'){
                if(stack.isEmpty()||stack.pop()!='[') return false;
            }else if(c=='}'){
                if(stack.isEmpty()||stack.pop()!='{') return false;
            }
        }
        return stack.isEmpty();
    }
}
