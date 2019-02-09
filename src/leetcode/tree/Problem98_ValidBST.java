package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Diane on 2019/2/9.
 * Goal:
 */
public class Problem98_ValidBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        List<Integer> sortedList = new ArrayList<Integer>(new HashSet<Integer>(list));
        Collections.sort(sortedList);
        return sortedList.equals(list);
    }


    void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

}
