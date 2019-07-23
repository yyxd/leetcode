package leetcode.cn.interview_problem.linkedlist_problem;

/**
 * Created by Diane on 2019-07-04.
 * Goal: 奇偶链表
 */
public class OddEvenList {
    public static ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode evenHead = new ListNode(-1);
        ListNode odd = head,even = evenHead;
        while (odd.next!=null&&odd.next.next!=null){
            even.next = odd.next;
            odd.next= odd.next.next;
            even =even.next;
            odd = odd.next;
        }
        if(odd.next!=null) {
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead.next;
        even.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
//        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
//        node6.next = node7;
        ListNode ans = oddEvenList(node1);
    }
}
