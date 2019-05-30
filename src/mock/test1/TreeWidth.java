package mock.test1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by HinTi on 2019/5/13.
 * Goal:
 */
//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class TreeWidth {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int maxWidth = 1;
        LinkedList<TreeNode> curList = new LinkedList<>();
        LinkedList<TreeNode> nextList ;
        TreeNode curNode ;
        boolean flag = true;
        curList.add(root);
        while (flag) {
            flag =false;
            nextList = new LinkedList<>();
            while (curList.size() > 0) {
                curNode = curList.poll();
                if (curNode != null) {
                    nextList.add(curNode.left);
                    nextList.add(curNode.right);
                    if(flag||curNode.left!=null||curNode.right!=null)
                        flag = true;
                } else {
                    nextList.add(null);
                    nextList.add(null);
                }
            }
            //去除队列前面为null的节点
            while (nextList.size()>0&&nextList.getFirst()==null){
                nextList.pollFirst();
            }
            //去除队列后面为null的节点
            while (nextList.size()>0&&nextList.getLast()==null){
                nextList.pollLast();
            }
            if(nextList.size()>maxWidth)
                maxWidth = nextList.size();
            curList = nextList;
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(new TreeNode(6));
        for(int i=0;i<6;i++)
            nodes.add(null);
        nodes.add(new TreeNode(9));
        while (nodes.size()>0&&nodes.getFirst()==null){
            nodes.pollFirst();
        }
        //去除队列后面为null的节点
        while (nodes.size()>0&&nodes.getLast()==null){
            nodes.pollLast();
        }
        System.out.println(nodes.size());
    }
}
