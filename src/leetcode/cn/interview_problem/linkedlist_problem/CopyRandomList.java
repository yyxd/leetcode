package leetcode.cn.interview_problem.linkedlist_problem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Diane on 2019-07-01.
 * Goal: 链表的深拷贝
 * Solution: 拷贝节点到原有链表上，然后再拷贝random节点，再将拷贝的链表进行分离
 */
public class CopyRandomList {
    public static Node copyRandomList(Node head) {
        Node point = head;
        // 复制链表
        while (point!=null) {
            Node cur = new Node(point.val,point.next,null);
            point.next = cur;
            point = cur.next;
        }

        // 复制 random节点
        point = head;
        while (point!=null){
            Node cur = point.next;
            if (point.random!=null)
                cur.random = point.random.next;
            point = cur.next;
        }
        // 分离链表
        Node copyHead = new Node();
        point = head;
        Node pre = copyHead;
        while (point!=null){
            Node cur = point.next;
            pre.next = cur;
            pre = cur;
            point.next = cur.next;
            point = point.next;
        }
        return copyHead.next;
    }

    public static Node CopyNodeListUsingHashMap(Node head){
        Node point = head;
        Map<Node,Node> nodeMap = new HashMap<>();
        while (point!=null){
            Node cur = new Node();
            cur.val = point.val;
            nodeMap.put(point,cur);
            point = point.next;
        }
        point = head;
        while (point!=null){
            Node cur = nodeMap.get(point);
            Node next = point.next;
            Node random = point.random;
            cur.next = next==null?null:nodeMap.get(next);
            cur.random = random==null?null:nodeMap.get(random);
            point = point.next;
        }
        return nodeMap.get(head);
    }
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.val = 1;
        Node node2 = new Node();
        node2.val = 2;
        Node node3 = new Node();
        node3.val = 3;
        Node node4 = new Node();
        node4.val = 4;
        Node node5 = new Node();
        node5.val = 5;
        Node node6 = new Node();
        node6.val = 6;
        Node node7 = new Node();
        node7.val = 7;
        Node node8 = new Node();
        node8.val = 8;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        node1.random = node3;
        node2.random = node3;
        node3.random = null;
        node4.random = node5;
        node5.random = node8;
        node6.random = node7;
        node7.random = node7;
        node8.random = node2;

        CopyNodeListUsingHashMap(node1);
    }
}
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }

    @Override
    public String toString() {
        String r = random==null?"null":(new Integer(random.val)).toString();
        return (new Integer(val)).toString()+" random "+r;
    }
}