package google.interview.binsearch;

import java.util.Stack;

/**
 * Created by HinTi on 2019/9/11.
 * Goal:
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Problem230 {
    public int kthSmallest(TreeNode root, int k) {
        int target = k - 1;
        int res = count(root.left);
        if (res == target) {
            return root.val;
        } else if (res > target) {
            return kthSmallest(root.left, k);
        } else
            return kthSmallest(root.right, k - res - 1);
    }

    // 返回一棵树的节点个数
    public int count(TreeNode node) {
        if (node == null) return 0;
        return count(node.left) + count(node.right) + 1;
    }

    // 利用树的中序遍历的性质
    public int kthSmallest2(TreeNode root, int k) {
        inOrder(root);
        target = k;
        return ans;
    }

    int target = 0;
    int ans = 0;
    int cur = 0;

    public void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        cur++;
        if (cur == target) {
            ans = node.val;
            return;
        }
        inOrder(node.right);
    }

    //利用栈来进行
    public int kthSmallest3(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            index++;
            if (index == k) return cur.val;
            cur = cur.right;
        }
        return 0;
    }
}