package leetcode.tree;

/**
 * Created by Diane on 2019/2/9.
 * Goal:
 */
public class Problem112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) return sum == 0;
        return root.left != null && hasPathSum(root.left, sum) || root.right != null && hasPathSum(root.right, sum);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
