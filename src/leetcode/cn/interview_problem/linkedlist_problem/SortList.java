package leetcode.cn.interview_problem.linkedlist_problem;

/**
 * Created by Diane on 2019-07-02.
 * Goal: 对链表进行排序 要求O(nlogn)
 * 归并排序
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return null;
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null)
            return node1 != null ? node1 : node2;
        ListNode pre = new ListNode(-1), head = pre;
        while (node1 != null && node2 != null) {
            ListNode curNode;
            if (node1.val < node2.val) {
                curNode = node1;
                node1 = node1.next;
            } else {
                curNode = node2;
                node2 = node2.next;
            }
            pre.next = curNode;
            pre = pre.next;
        }
        if(node1!=null) pre.next = node1;
        else  pre.next = node2;
        head = head.next;
        return head;
    }
}
