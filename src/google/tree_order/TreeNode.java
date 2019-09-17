package google.tree_order;

/**
 * Created by HinTi on 2019/9/16.
 * Goal:
 */
public class TreeNode {
    int val;
    char id;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, char id) {
        this.val = val;
        this.id = id;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root_left = new TreeNode(2);
        TreeNode root_right = new TreeNode(3);
        root.left = root_left;
        root.right = root_right;
        TreeNode ll = new TreeNode(4);
        TreeNode rl = new TreeNode(5);
        TreeNode rr = new TreeNode(6);
        root_left.left = ll;
        root_right.left = rl;
        root_right.right = rr;
        PreOrder.preOrder(root);
    }
}