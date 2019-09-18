package google.interview.linkednode;

/**
 * Created by HinTi on 2019/9/12.
 * Goal:
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode start = head;
        // 如果无环，退出循环，返回null
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (start != slow) {
                    slow = slow.next;
                    start = start.next;
                }
                return slow;
            }
        }
        return null;
    }
}