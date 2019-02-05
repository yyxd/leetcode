package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Diane on 2019/2/5.
 * Goal:
 */
public class Problem141_LinkedListCycle {
    /**
     * 方法1 如果链表中有环，那么一定有一个节点会被访问第二次，使用hashSet保存节点是否被访问过
     * @param head 链表头结点
     * @return 是否有环
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head))
                return true;
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 方法二：建立两个指针，遍历链表的速度一个快，一个慢，如果表中有环，快的一定会追上慢的
     * @param head 链表头结点
     * @return 是否有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head, slow = head;
        fast = fast.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}