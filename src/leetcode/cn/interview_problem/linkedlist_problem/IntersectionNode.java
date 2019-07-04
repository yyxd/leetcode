package leetcode.cn.interview_problem.linkedlist_problem;

/**
 * Created by HinTi on 2019/7/3.
 * Goal: 相交链表
 * Solution： 如果两个链表相交，那么末尾节点一定是一致的，获取链表A的长度，链表B的长度。根据长度分别为longList lk 和 shortList sk
 * 让 longlist 先走lk-sk 的距离
 */
public class IntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode pointA = headA,pointB = headB;
        int lenA = 1,lenB = 1;
        while (pointA.next!=null) {
            pointA = pointA.next;
            lenA++;
        }
        while (pointB.next!=null) {
            pointB = pointB.next;
            lenB++;
        }
        if(pointA!=pointB) return null;
        ListNode longList = headA,shortList = headB;
        int longLen = lenA,shortLen = lenB;
        if(lenA<lenB){
            longList = headB;
            shortList = headA;
            longLen = lenB;
            shortLen = lenA;
        }
        int i=0;
        while (i++<longLen-shortLen&& longList!=null)
            longList = longList.next;
        i = longLen-shortLen;
        while (i++<longLen&& longList!=null&& shortList!=null){
            if(longList==shortList)
                return longList;
            longList = longList.next;
            shortList = shortList.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode ans  = getIntersectionNode(node,node);
        System.out.println(ans==null?"null":ans.val);
    }
}