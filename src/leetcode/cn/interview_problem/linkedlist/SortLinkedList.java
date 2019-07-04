package leetcode.cn.interview_problem.linkedlist;

import leetcode.sort.HeapSort;

import java.util.List;

/**
 * Created by HinTi on 2019/7/3.
 * Goal: 使用归并对链表排序
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
public class SortLinkedList {

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    // 递归的归并
    public ListNode mergeSortRercurse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode slow = head,fast = slow.next;
        // 找链表的中点
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = mergeSortRercurse(slow.next);
        slow.next = null;
        ListNode left = mergeSortRercurse(head);
        return merge(left,right);
    }

    // 自底向上的归并
    public ListNode mergeSort(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode point = head;
        int len =0;
        while (point!=null){
            len++;
            point = point.next;
        }
        ListNode dumpyHead = new ListNode(0);
        dumpyHead.next = head;
        for(int step = 1;step<len;step<<=1){
            ListNode current = dumpyHead.next;
            ListNode tail = dumpyHead;
            while (current!=null){
                ListNode left = current;
                ListNode right = cut(left,step);
                current = cut(right,step);
                tail.next = merge(left,right);
                // 获取合并完成后的节点的末端节点
                while (tail.next!=null){
                    tail = tail.next;
                }
            }
        }
        return dumpyHead.next;
    }
    public ListNode cut(ListNode node ,int step){
        ListNode p = node;
        while (--step>0&&p!=null){
            p = p.next;
        }
        if(p==null) return null;
        ListNode cutHead = p.next;
        p.next = null;
        return cutHead;
    }

    public ListNode merge(ListNode head1,ListNode head2){
        ListNode soldier = new ListNode(-1),pre = soldier;

        while (head1!=null&&head2!=null){
            ListNode cur;
            if(head1.val<head2.val) {
                cur = head1;
                head1 = head1.next;
            }else{
                cur = head2;
                head2 = head2.next;
            }
            pre.next = cur;
            pre = pre.next;
        }
        pre.next = head1==null?head2:head1;
        return soldier.next;
    }

    public static void main(String[] args) {
        SortLinkedList sortLinkedList = new SortLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node1.next=node2;
       node2.next=node3;
        node3.next=node4;
        sortLinkedList.mergeSort(node1);
//        ListNode left = node1;
//        ListNode right =sortLinkedList.cut(left,2);
    }
}

