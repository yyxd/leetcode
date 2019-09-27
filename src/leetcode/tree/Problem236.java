package leetcode.tree;

/**
 * Created by HinTi on 2019/9/25.
 * Goal:LCA lowest common ancestor
 */
public class Problem236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        boolean f1 = findSubNode(left, p);
        boolean f2 = findSubNode(left, q);
        TreeNode res = root;
        if (f1 == f2) {
            res = f1 ? lowestCommonAncestor(left, p, q) : lowestCommonAncestor(right, p, q);
        }
        return res;
    }

    public boolean findSubNode(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;
        else return findSubNode(root.left, node) || findSubNode(root.right, node);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null)
            return root;
        else if (left != null)
            return left;
        else
            return right;
    }
}