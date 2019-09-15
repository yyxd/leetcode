package google.interview.linkednode;

/**
 * Created by HinTi on 2019/9/12.
 * Goal: leetcode 1171
 */
public class RemoveZeroSumSublists {
    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode soldier = new ListNode(0);
        soldier.next = head;
        ListNode pre = soldier;
        ListNode cur = head;
        while (cur != null) {
            cur.val = cur.val + pre.val;
            ListNode p = soldier;
            while (p.val != cur.val && p != cur) {
                p = p.next;
            }
            p.next = cur.next;
            pre = p;
            cur = cur.next;
        }
        ListNode p = soldier.next;
        int sum = 0;
        while (p != null) {
            p.val = p.val - sum;
            sum += p.val;
            p = p.next;
        }
        return soldier.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(-3);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = removeZeroSumSublists(node1);
        while (node != null) {
            System.out.printf("%d ", node.val);
            node = node.next;
        }
    }
}