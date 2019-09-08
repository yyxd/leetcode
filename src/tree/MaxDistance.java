package tree;

/**
 * Created by HinTi on 2019/8/29.
 * Goal: 树中最长的距离，相邻节点距离为1
 */
public class MaxDistance {
    public int maxPathSum(TreeNode root) {
        int[] res = maxPath(root);
        return Math.max(res[1],res[2]);
    }
    // res[0] 深度，res[1] 自己在路径中的最大值，res[2] 自己不再路径中的最大值
    public int[] maxPath(TreeNode root){
        if(root==null)
            return new int[3];
        int[] left = maxPath(root.left);
        int[] right = maxPath(root.right);
        int[] res = new int[3];
        res[0] = Math.max(left[0],right[0])+1;
        res[1] = left[0]+right[0]+1;
        res[2] = Math.max(Math.max(left[1],left[2]),Math.max(right[1],right[2]));
        return res;
    }
}