package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Diane on 2019/2/9.
 * Goal: 翻转二叉树
 */
public class Problem226_InvertBinaryTree {
    /**
     * 翻转树，递归解法
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public TreeNode invertTreeByqueue(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return null;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        return root;
    }
}
