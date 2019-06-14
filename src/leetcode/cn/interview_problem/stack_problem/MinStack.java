package leetcode.cn.interview_problem.stack_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diane on 2019-06-13.
 * Goal:
 */

public class MinStack {

    /** initialize your data structure here.
     最小栈的思路是在pop的时候如果发现当前元素=最小元素,则去寻找最小元素
     另一个想法是使用两个栈，另一个栈存储的是当前最小元素值
     */
    private List<Integer> stack ;
    private int min = Integer.MAX_VALUE;
    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
        min = Math.min(x,min);
    }

    public void pop() {
        if(stack.size()>0){
            int cur = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            if(cur==min){
                min = Integer.MAX_VALUE;
                for(int i=0;i<stack.size();i++) {
                    min = Math.min(min, stack.get(i));
                }
            }
        }

    }

    public int top() {
        if(stack.size()>0)
            return stack.get(stack.size()-1);
        return 0;
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        /**
         * Your MinStack object will be instantiated and called as such:*/
          MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */