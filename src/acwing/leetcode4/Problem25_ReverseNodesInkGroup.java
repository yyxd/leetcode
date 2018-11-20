package acwing.leetcode4;

/**
 * Created by HinTi on 2018/11/20.
 * Goal:
 */
public class Problem25_ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1) return head;
        ListNode tail = head;
        int len = 0;
        while (tail!=null) {
            len++;
            tail = tail.next;
        }
        int times = len/k;
        ListNode pstart = head,ans=head,pt = new ListNode(0);
        for(int i=0;i<times;i++)
        {
            ListNode guard = pstart.next;
            ListNode pend = pstart;
            for(int j=1;j<k;j++)
                pend = pend.next;
            pstart.next = pend.next;
            pend.next = pstart;
            pt.next = pend;
            while (guard!=pend){
                ListNode temp = guard.next;
                guard.next = pend.next;
                pend.next = guard;
                guard = temp;
            }
            if(i==0)
                ans = pend;
            pt.next = pend;
            pt = pstart;
            pstart = pstart.next;
        }
        return ans;
    }

    /**
     * 链表翻转
     * @param head 链表的头结点
     * @return 翻转后的链表的的头结点（即原链表的尾节点）
     */
    public ListNode reverseNode(ListNode head){
        ListNode guard = head.next;
        ListNode tail = head;
        while (tail.next!=null)
            tail = tail.next;
        head.next = tail.next;
        tail.next = head;
        while (guard!=tail){
            ListNode temp = guard.next;
            guard.next = tail.next;
            tail.next = guard;
            guard = temp;
        }
        return tail;
    }

    public static void main(String[] args) {
        ListNode node_0 = new ListNode(1);
        ListNode node_1 = new ListNode(2);
        ListNode node_2 = new ListNode(3);
        ListNode node_3 = new ListNode(4);
        ListNode node_4 = new ListNode(5);
        ListNode node_5 = new ListNode(6);
        ListNode node_6 = new ListNode(7);
        ListNode node_7 = new ListNode(8);
        ListNode node_8 = new ListNode(9);
        ListNode node_9 = new ListNode(10);
        node_0.next = node_1;
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        node_5.next = node_6;
        node_6.next = node_7;
        node_7.next = node_8;
        node_8.next = node_9;
        node_9.next = null;
        Problem25_ReverseNodesInkGroup pr = new Problem25_ReverseNodesInkGroup();
        ListNode head = pr.reverseKGroup(node_0,4);
//        ListNode head = pr.reverseNode(node_0);
        while (head!=null){
            System.out.print(head.val+"->");
            head = head.next;
        }
    }
}
