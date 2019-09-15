package google.interview.linkednode;

import java.util.Stack;

/**
 * Created by HinTi on 2019/9/12.
 * Goal: 判断链表是否是回文链表
 */
public class PalindromeLN {

    // 利用栈来实现
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Stack<ListNode> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            stack.push(slow);
            slow = slow.next;
        }
        // 判断节点为奇数个还是偶数个
        // fast 为null
        if (fast != null)
            slow = slow.next;
        while (!stack.isEmpty()) {
            if (stack.pop().val != slow.val)
                return false;
            slow = slow.next;
        }
        return true;
    }

    // 利用反转链表来实现
    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null)
            slow = slow.next;
        // 反转链表
        ListNode soldier = new ListNode(-1);
        while (slow != null) {
            ListNode cur = slow;
            slow = slow.next;
            cur.next = soldier.next;
            soldier.next = cur;
        }
        soldier = soldier.next;
        while (soldier != null) {
            if (head.val != soldier.val)
                return false;
            head = head.next;
            soldier = soldier.next;
        }
        return true;
    }
}