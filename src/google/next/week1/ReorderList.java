package google.next.week1;

import java.util.List;

/**
 * Created by HinTi on 2019/7/12.
 * Goal: 将单链表重排
 * L0→L1→…→Ln-1→Ln 变为 L0→Ln→L1→Ln-1→L2→Ln-2
 * <p>
 * Solution: 首先找到链表的一半，对链表的后半部分进行倒序处理，再将后半部分的
 */




public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        ListNode midNode = getMid(head);
        ListNode reverseMid = reverseList(midNode.next);
        midNode.next = null;
        ListNode headcopy = head;
        while (headcopy!=null&&reverseMid!=null){
            ListNode before = headcopy;
            ListNode after = reverseMid;
            headcopy = headcopy.next;
            reverseMid = reverseMid.next;
            after.next = before.next;
            before.next = after;
        }
//        if(headcopy!=null) headcopy.next = null;
//        else if(reverseMid!=null) reverseMid.next = null;
    }

    public ListNode reverseList(ListNode head){
        ListNode soldier = new ListNode(-1);
        while (head!=null){
            ListNode cur = head;
            head = head.next;
            cur.next = soldier.next;
            soldier.next = cur;
        }
        return soldier.next;
    }

    public ListNode getMid(ListNode head){
        ListNode fast = head.next,slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ReorderList rl = new ReorderList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        rl.reorderList(node1);
        while (node1!=null){
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

}