package topGoogleQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by HinTi on 2019/9/26.
 * Goal:
 */
public class Problem1110 {
    List<TreeNode> ans = new ArrayList<>();
    HashSet<Integer> deleteSet = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i = 0; i < to_delete.length; i++)
            deleteSet.add(to_delete[i]);
        delNodes(true, root);
        return ans;
    }
    public TreeNode delNodes(boolean is_root, TreeNode node) {
        if (node == null) return null;
        boolean deleted = deleteSet.contains(node.val);
        if (is_root && !deleted) ans.add(node);
        node.left = delNodes(deleted, node.left);
        node.right = delNodes(deleted, node.right);
        return deleted ? null : node;
    }


}