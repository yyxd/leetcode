package google.tree_order;

import java.util.HashSet;
import java.util.Stack;

/**
 * Created by HinTi on 2019/9/16.
 * Goal: 后序遍历
 * 左右根节点
 * 根节点入栈，右节点入栈，左节点入栈，
 * 直到当前节点的左右节点都为空，出栈，要保留节点访问过的记录
 * 即当前节点的左右节点都已经入栈了，要保存访问过的节点信息
 */
public class PostOrder {
    public static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        HashSet<TreeNode> visitedSet = new HashSet<>();
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            while (cur != null && !visitedSet.contains(cur)) {
                visitedSet.add(cur);
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
                cur = cur.left == null ? cur.right : cur.left;
            }
            // poll 为空时返回空 pop 抛出 Exception
            cur = stack.pop();
            if (cur != null)
                System.out.print(cur.val + " ");
        }
        System.out.println();
    }
}