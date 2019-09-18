package google.tree_order;

import java.util.LinkedList;

/**
 * Created by HinTi on 2019/9/16.
 * Goal: 中序遍历的非递归实现 左中右
 * 当前节点为根节点
 * 当前节点不为null 或 栈不为空时循环，
 *      当前节点不为空时循环，将当前节点入栈，当前节点指向左节点。
 *      当前节点->栈顶元素出栈，访问 当前节点指向右节点
 */
public class InOrder {
    public static void inOrder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        PostOrder.postOrder(root);
    }
}