package topGoogleQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by HinTi on 2019/9/27.
 * Goal:
 */
public class Problem199 {
    // BFS level order
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (size == 0)
                    result.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return result;
    }

    // recursive without extra space
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getRight(root,result,0);
        return result;
    }
    // 先序遍历 根右左，保证每一层中是先访问右边的节点
    public void getRight(TreeNode node, List<Integer> res, int curDepth) {
        if (node == null) return;
        if (curDepth == res.size())
            res.add(node.val);
        getRight(node.right, res, curDepth + 1);
        getRight(node.left, res, curDepth + 1);
    }

}