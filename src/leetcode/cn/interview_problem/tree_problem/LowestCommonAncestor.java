package leetcode.cn.interview_problem.tree_problem;

/**
 * Created by Diane on 2019-07-06.
 * Goal: 两个节点的最近公共祖先
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root==null||root==p||root==q) return root;
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);
      if(left!=null&&right!=null) return root;
      return left==null?right:left;
    }

    public boolean found(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root.val == p.val) return true;
        return found(root.left, p) || found(root.right, p);
    }
}
