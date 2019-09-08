package tree;

/**
 * Created by HinTi on 2019/8/29.
 * Goal: 路径：从树的任意节点出发，达到任意节点的序列。最大路径和，节点的val
 */
public class MaxPath {
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    // res[0] 自己在路径中的最大值，res[1] 自己不再路径中的最大值,res[2] 左子树+ root.val, res[3] 右子树+root.val
    public int[] maxPath(TreeNode root) {
        if (root == null) {
            int[] res = new int[4];
            res[0] = Integer.MIN_VALUE;
            res[1] = Integer.MIN_VALUE;
            res[2] = Integer.MIN_VALUE;
            res[3] = Integer.MIN_VALUE;
            return res;
        }
        int[] left = maxPath(root.left);
        int[] right = maxPath(root.right);
        int[] res = new int[4];
        // 当前节点不在路径中的最大值
        res[1] = Math.max(Math.max(left[0], left[1]), Math.max(right[0], right[1]));
        //左子树最长路径+当前节点值
        res[2] = root.val+Math.max(Math.max(left[2],left[3]),0);
        //右子树最长路径+当前节点值
        res[3] = root.val+Math.max(Math.max(right[2],right[3]),0);
        // 当前节点在路径中的最大值
        res[0] = res[2]+res[3]-root.val;
        return res;
    }

    public int maxSum = Integer.MIN_VALUE;
    public int maxGain(TreeNode root){
        if(root==null) return 0;
        int left = maxGain(root.left);
        int right = maxGain(root.right);
        maxSum = Math.max(maxSum,Math.max(left,right)+root.val);
        return Math.max(left,right)+root.val;
    }
}