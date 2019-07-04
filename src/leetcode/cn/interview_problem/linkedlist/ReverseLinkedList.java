package leetcode.cn.interview_problem.linkedlist;


/**
 * Created by HinTi on 2019/7/3.
 * Goal:
 */
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        return reverseListRecursive(head);
    }


    public static ListNode reverseListRecursive(ListNode node){
        if(node==null||node.next==null) return node;
        ListNode next = reverseListRecursive(node.next);
        node.next.next = node; // 翻转指针，node 与 node.next 成环，再断开连接
        node.next = null;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);

        ListNode node2 = new ListNode(3);

        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = reverseListRecursive(head);
    }
}