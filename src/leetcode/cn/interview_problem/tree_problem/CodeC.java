package leetcode.cn.interview_problem.tree_problem;

/**
 * Created by Diane on 2019-07-06.
 * Goal: 树的序列化与反序列化
 * 层次遍历
 *
 */
public class CodeC {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(root.val);
        }
        stringBuilder.append(",");
        stringBuilder.append(serialize(root.left));
        stringBuilder.append(",");
        stringBuilder.append(serialize(root.right));
        return "";

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}
