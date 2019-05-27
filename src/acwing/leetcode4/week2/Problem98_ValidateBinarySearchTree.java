package acwing.leetcode4.week2;



/**
 * Created by HinTi on 2018/11/28.
 * Goal:
 */
public class Problem98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root){
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long minVal,long maxval)
    {
        if(root==null) return true;
        if(root.val>=maxval||root.val<=minVal) return false;
        return isValidBST(root.left,minVal,root.val)&&isValidBST(root.right,root.val,maxval);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x){
        val = x;
    }
}