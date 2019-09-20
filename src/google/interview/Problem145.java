package google.interview;

import google.next.week1.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HinTi on 2019/9/20.
 * Goal: postOrder
 */
public class Problem145 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return ans;
    }

    public void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        ans.add(node.val);
    }

    public List<Integer> postorderIteratively(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        HashSet<TreeNode> visitedSet = new HashSet<>();
        stack.push(cur);
        while (cur != null || !stack.isEmpty()) {
            while (cur != null && !visitedSet.contains(cur)) {
                visitedSet.add(cur);
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
                cur = cur.left == null ? cur.right : cur.left;
            }
            // poll 为空时返回空 pop 抛出 Exception
            cur = stack.pollLast();
            if (cur != null)
                results.add(cur.val);
        }
        return results;
//        System.out.println();
//        List<Integer> results = new ArrayList<>();
//        Set<TreeNode> visited = new HashSet<>();
//        // when node's
//        //add node's right 、left to stack
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        TreeNode cur = root;
//        stack.push(cur);
//        while (cur != null || !stack.isEmpty()) {
//            while (cur != null && !visited.contains(cur)) {
//                visited.add(cur);
//                if (cur.right != null)
//                    stack.push(cur.right);
//                if (cur.left != null)
//                    stack.push(cur.left);
//                cur = cur.left != null ? cur.left : cur.right;
//            }
//            cur = stack.pollLast();
//            if (cur != null)
//                results.add(cur.val);
//        }

    }
}