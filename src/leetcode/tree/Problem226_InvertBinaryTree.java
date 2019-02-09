package leetcode.tree;

/**
 * Created by Diane on 2019/2/9.
 * Goal:
 */
public class Problem226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
