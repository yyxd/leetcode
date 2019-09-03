package leetcode.cn.interview_problem.tree_problem;

/**
 * Created by Diane on 2019-08-27.
 * Goal:
 */
public class RobIII {
    public int rob(TreeNode root) {
        int[] res = getMax(root);

        return Math.max(res[0],res[1]);
    }

    // 返回两个数，该节点加入自己的Max值res[0]，不加入自己的Max值res[1] max(res[0],res[1]) 表示以当前节点为根能抢劫的最大值
    public int[] getMax(TreeNode root) {
        if (root == null)
            return new int[2];
        int[] left = getMax(root.left);
        int[] right = getMax(root.right);

        int[] res = new int[2];
        res[0] = root.val + left[1] + right[1];//加入当前节点，那就 = 当前值+不加入左子节点的max+不加入右子节点的max
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);// 不加入当前节点，则 = 左子树的max +右子树的max
        return res;
    }
}
