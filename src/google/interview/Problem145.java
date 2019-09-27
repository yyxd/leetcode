package google.interview;

import google.tree_order.TreeNode;

import java.util.*;

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
            cur = stack.poll();
            if (cur != null)
                results.add(cur.val);
        }
        return results;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list.add("1");
        list2.add(1);
        System.out.println(list.get(0).getClass());
        System.out.println(list2.get(0).getClass());
        System.out.println(list.getClass()==list2.getClass());
        Problem145 problem145 = new Problem145();
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.left.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(7);
        List<Integer> ans = problem145.postorderIteratively(root);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}