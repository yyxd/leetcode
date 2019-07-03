package leetcode.cn.interview_problem.linkedlist_problem;

/**
 * Created by Diane on 2019-07-04.
 * Goal:
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode soldier = new ListNode(-1);

        while (head!=null){
            ListNode list = soldier.next;
            soldier.next = head;
            head = head.next;
            soldier.next.next = list;

        }
        return soldier.next;
    }
}
