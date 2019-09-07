package google.next.week1;

/**
 * Created by HinTi on 2019/7/12.
 * Goal: 最大二叉树
 */
public class MaxBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length-1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums,int start,int end) {
        if(end<start) return null;
        int maxIndex = start;
        int max = Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            if(max<nums[i]){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        TreeNode left = constructMaximumBinaryTree(nums,start,maxIndex-1);
        TreeNode right = constructMaximumBinaryTree(nums,maxIndex+1,end);
        root.left = left;
        root.right = right;
        return root;
    }
}