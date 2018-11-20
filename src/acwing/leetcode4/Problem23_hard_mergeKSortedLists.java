package acwing.leetcode4;
/**
 * Created by HinTi on 2018/11/19.
 * Goal: 归并n个有序链表
 */
//算法复杂度为O(kn),k是链表的长度，n是链表的个数，beats 12.4%
//待优化
public class Problem23_hard_mergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<=0) return null;
        if(lists.length==1) return lists[0];
        ListNode ans = lists[0];
        for(int i = 1;i<lists.length;i++){
           ans = mergeList(ans,lists[i]);
        }
        return ans;
    }

    public ListNode mergeList(ListNode list1,ListNode list2){
        ListNode p1 = list1, p2= list2;
        ListNode pMerge = new ListNode(0);
        ListNode ans = pMerge;
        while (p1!=null&&p2!=null){
            if (p1.val<p2.val) {
                pMerge.next = p1;
                pMerge = pMerge.next;
                p1 = p1.next;
            }else {
                pMerge.next = p2;
                pMerge = pMerge.next;
                p2 = p2.next;
            }
        }
        if(p1!=null)
            pMerge.next = p1;
        else
            pMerge.next = p2;
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[3];
        ListNode node0_0 = new ListNode(1);
        ListNode node0_1 = new ListNode(3);
        ListNode node0_2 = new ListNode(5);
        ListNode node0_3 = new ListNode(9);
        node0_0.next = node0_1;
        node0_1.next = node0_2;
        node0_2.next = node0_3;
        node0_3.next = null;
        nodes[0] = node0_0;

        ListNode node1_0 = new ListNode(2);
        ListNode node1_1 = new ListNode(8);
        ListNode node1_2 = new ListNode(9);
        node1_0.next = node1_1;
        node1_1.next = node1_2;
        node1_2.next = null;
        nodes[1] = node1_0;

        ListNode node2_0 = new ListNode(4);
        ListNode node2_1 = new ListNode(7);
        node2_0.next = node2_1;
        node2_1.next = null;
        nodes[2] = node2_0;

        Problem23_hard_mergeKSortedLists problem = new Problem23_hard_mergeKSortedLists();
        ListNode ans = problem.mergeKLists(nodes);
        while (ans!=null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


