package acmcoder;

import java.util.LinkedList;

/**
 * Created by Diane on 2019-09-21.
 * Goal:
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack.pollFirst());
        System.out.println(stack.pollLast());

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue.poll());
    }
}
