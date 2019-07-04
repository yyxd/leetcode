package leetcode.cn.interview_problem.linkedlist_problem;

/**
 * Created by Diane on 2019-07-04.
 * Goal: O(n) 时间复杂度，O(1) 空间复杂度
 * 首先找到中点，然后翻转后半段的链表，然后与前半段进行比较
 */
public class IsPalindromeList {
    public boolean isPalindrome(ListNode head){
        if(head==null||head.next==null) return true;
        ListNode fast = head.next,slow = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = slow.next;
        ListNode left = head;
        slow.next =null;
        right = reverseListNode(right);
        while (left!=null&&right!=null){
            if(left.val!=right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverseListNode(ListNode node){
        ListNode soldier = new ListNode(-1);
        while (node!=null){
            ListNode list = soldier.next;
            soldier.next = node;
            node = node.next;
            soldier.next.next = list;
        }
        return soldier.next;
    }

}
