package google.tree_order;

import java.util.LinkedList;

/**
 * Created by HinTi on 2019/9/16.
 * Goal: 先序遍历的非递归实现
 * 根节点 入栈
 * 栈不为空：出栈，右节点入栈，左节点入栈
 */


public class PreOrder {
    public static void preOrder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
            System.out.print(cur.val + " ");
        }
        System.out.println();
    }
}