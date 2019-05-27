package acwing.leetcode4.week2;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by HinTi on 2018/11/28.
 * Goal:
 */
public class Problem173_BSTIterator {
    private Stack<TreeNode> nodeStack;
    public Problem173_BSTIterator(TreeNode root) {
        nodeStack = new Stack<>();
        add(root);
    }
    private void add(TreeNode node) {
        while (node != null) {
            nodeStack.push(node);
            node = node.left;
        }
    }
    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }
    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = nodeStack.pop();
        add(node.right);
        return node.val;
    }

    public static TreeNode genTree(Integer[] nums) {
        TreeNode[] tree = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != null)
                tree[i] = new TreeNode(nums[i]);
            else
                tree[i] = null;
        }
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.offer(tree[0]);
        for(int i = 0;i<nums.length;i++)
        {
            TreeNode father = queue.peek();
            if(i%2!=0) {
                father.left = tree[i];
            }else {
                father.right = tree[i];
                queue.remove();
            }
            if(tree[i]!=null)
                queue.offer(tree[i]);
        }
        return tree[0];
    }

    public static void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "\t");
            printTree(root.left);
            printTree(root.right);
        } else System.out.print("null\t");

    }

    public static void main(String[] args) {

        Integer nums[] = {2, 1, 3};
        Integer num2[] = {5, 1, 7, null, null, 6, 8};
        TreeNode root1 = genTree(nums);
//        printTree(root1);
//        System.out.println();
        TreeNode root2 = genTree(num2);
//        printTree(root2);
        Problem173_BSTIterator problem = new Problem173_BSTIterator(root2);
        while (problem.hasNext()){
            System.out.println(problem.next());
        }
//        System.out.println();
    }
}
