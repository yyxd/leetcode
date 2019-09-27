package topGoogleQuestions;

/**
 * Created by HinTi on 2019/9/27.
 * Goal:
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

public class Problem117 {
    public Node connect(Node root) {
        Node cur = root;// 第一层已经是使用next连接好的
        Node dummyHead = new Node(0);// 下一层的开始节点
        Node pre = dummyHead;// 下一层的pre节点
        while (cur != null) {
            if (cur.left != null) {
                pre.next = cur.left;
                pre = pre.next;
            }
            if (cur.right != null) {
                pre.next = cur.right;
                pre = pre.next;
            }
            cur = cur.next;
            if (cur == null) {// 跳转到下一层
                cur = dummyHead.next;
                dummyHead.next = null;
                pre = dummyHead;
            }
        }
        return root;
    }
}