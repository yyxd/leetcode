package leetcode.tree.tranverse;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Diane on 2019-05-15.
 * Goal: 迭代遍历树
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TreeOrderIter {
    public void preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            if(cur!=null){
                ans.add(cur.val);// 访问当前节点
                stack.push(cur); // 将节点存入栈中
                cur = cur.left;  // 访问当前节点的左子节点
            }else { // 当根节点为空时，说明左子树已经遍历完了，接着访问右子树
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }

    public void inOrder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

    }
}
