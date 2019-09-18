package google.interview.linkednode;

/**
 * Created by HinTi on 2019/9/13.
 * Goal:
 */
public class Problem19 {
    public ListNode removeNthFromFront(ListNode head, int n) {
        ListNode soldier = new ListNode(-1);
        soldier.next = head;
        ListNode cur = soldier;
        for (int i = 1; i <= n - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return soldier.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode soldier = new ListNode(-1);
        soldier.next = head;
        ListNode cur = soldier;
        for (int i = 1; i <= n + 1; i++) {
            cur = cur.next;
        }
        ListNode node = soldier;
        while (cur != null) {
            cur = cur.next;
            node = node.next;
        }
        node.next = node.next.next;
        return soldier.next;
    }
}