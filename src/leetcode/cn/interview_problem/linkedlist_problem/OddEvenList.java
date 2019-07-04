package leetcode.cn.interview_problem.linkedlist_problem;

/**
 * Created by Diane on 2019-07-04.
 * Goal:
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode oddHead = head,evenHead = head.next;
        ListNode odd = oddHead,even = evenHead;
        while (){

        }
        odd.next = evenHead;
        return oddHead;
    }
}
