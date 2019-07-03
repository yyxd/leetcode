package leetcode.cn.interview_problem.linkedlist_problem;

/**
 * Created by Diane on 2019-07-02.
 * Goal: 判断链表是否有环,利用快慢指针
 */
public class ListHasCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode faster = head.next;
        ListNode lower = head;
        while (faster!=lower){
            if(faster==null||faster.next==null)
                return false;
            faster = faster.next.next;
            lower = lower.next;
        }
        return true;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}