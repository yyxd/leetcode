package leetcode.tree;

/**
 * Created by Diane on 2019/2/9.
 * Goal:
 */
public class Problem104_MaxDepthBT {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return(1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }
}
