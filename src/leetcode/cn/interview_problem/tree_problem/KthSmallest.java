package leetcode.cn.interview_problem.tree_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diane on 2019-07-06.
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

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> sortedTree = new ArrayList<>();
    nodePoint(root, sortedTree,k);
        return sortedTree.get(k-1).val;
}

    public void nodePoint(TreeNode node, List<TreeNode> sortedTree, int k){
        if (node==null) return;
        nodePoint(node.left, sortedTree,k);
        if(sortedTree.size()==k) return;
        sortedTree.add(node);
        nodePoint(node.right, sortedTree, k);
    }
}
