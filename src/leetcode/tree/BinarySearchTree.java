package leetcode.tree;

/**
 * Created by HinTi on 2019/2/23.
 * Goal: 二分搜索树,左子树<节点值<右子树
 */
public class BinarySearchTree {
    TreeNode root = null;

    public BinarySearchTree(int[] nums) {
        for (int num : nums) insert(num);
    }

    public void insert(int num) {
        if (root == null) {
            root = new TreeNode(num);
            return;
        }
        TreeNode p = root;
        while (p != null) {
            if (num <= p.val) {
                p = p.left;
            } else p = p.right;
        }
        p = new TreeNode(num);
    }

    public void delete(int num) {
        TreeNode deleteNode = root;
        TreeNode faterNode = null;
        boolean flag = true;//true代表待删除节点是父节点的左子节点，false代表右子节点。
        //查找待删除节点的父节点
        while (deleteNode!=null&&deleteNode.val!=num){
            faterNode = deleteNode;
            if(num>deleteNode.val) deleteNode = deleteNode.right;
            else deleteNode = deleteNode.right;
        }
        if (deleteNode == null) {
            System.out.println("树中没有此节点");
            return ;
        }
        //情况一：待删除的节点没有子节点（左子节点和右子节点都为空），只需要将该节点置为null即可
        //情况二，删除的节点只有一个节点(左子节点为空,右子节点不为空||左子节点不为空，右子节点为空),只需要将该节点的父节点指向该节点不为空的子节点即可。
        //情况三，待删除的节点的左右子节点都不为空，找到这个节点的右子树的最小节点，把它的值替换成到要删除的节点中，把该节点变为要删除的节点（这个节点是只有右子节点的）

        //情况三
        if(deleteNode.left!=null&&deleteNode.right!=null){
            //右子树的最小节点，即右子树的最左子节点，最左子节点的左子节点一定为空，删除该节点，只需将该节点的父节点指向该节点的右节点
            TreeNode rleft = deleteNode.right;
            TreeNode rleftFater = deleteNode;
           while (rleft.left!=null){
               rleftFater = rleft;
               rleft = rleft.left;
           }
            deleteNode.val = rleft.val;//将rleft的数据替换到待删除的节点中
            faterNode = rleftFater;
            deleteNode = rleft;
        }

        //情况一、二 删除节点是叶子节点或者仅有一个子节点
        TreeNode child;
        if(deleteNode.left!=null) child = deleteNode.left;
        else if(deleteNode.right!=null) child = deleteNode.right;
        else child = null;
        if(faterNode==null) root = child;//删除的是根节点
        else if(faterNode.left == deleteNode) faterNode.left = child;
        else faterNode.right = child;
    }

    public TreeNode find(int num) {
        TreeNode p = root;
        while (p != null) {
            if (p.val == num) return p;
            else if (p.val < num) p = p.left;
            else p = p.right;
        }
        return null;
    }
}
