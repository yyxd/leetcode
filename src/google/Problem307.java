package google;

/**
 * Created by Diane on 2019-09-25.
 * Goal:
 */
public class Problem307 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray array = new NumArray(nums);
        for (int i = 0; i < nums.length; i++)
            array.update(i, nums[i]);

        System.out.println(array.sumRange(0, 2));
        array.update(1, 2);
        System.out.println(array.sumRange(0, 2));
    }
}

class NumArray {
    SegmentTree segmentTree;

    public NumArray(int[] nums) {
        segmentTree = new SegmentTree(0, nums.length);
        for (int i = 0; i < nums.length; i++)
            update(i, nums[i]);
    }

    public void update(int i, int val) {
        segmentTree.update(i, val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.search(i, j);
    }
}

class Node {
    int val; // 存储值
    int left;
    int right;
    Node lchild;
    Node rchild;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

class Merger {
    private static int plusMerge(int a, int b) {
        return a + b;
    }

    private static int minMerge(int a, int b) {
        return Math.min(a, b);
    }

    private static int maxMerge(int a, int b) {
        return Math.max(a, b);
    }

    public static int merge(int a, int b) {
        return plusMerge(a, b);
    }
}

class SegmentTree {
    Node root;

    SegmentTree(int left, int right) {
        root = buildTree(left, right);
    }

    public Node buildTree(int left, int right) {
        Node root = new Node(left, right);
        if (right - left >= 1) {
            int mid = (left + right) / 2;
            root.lchild = buildTree(left, mid);
            root.rchild = buildTree(mid + 1, right);
        }
        return root;
    }

    public int search(int left, int right) {
        return search(root, left, right);
    }

    private int search(Node node, int left, int right) {
        if (node == null || left > right) return 0;
        if (node.left == left && node.right == right) return node.val;
        int mid = (node.left + node.right) / 2;
        int value = 0;
        if (right <= mid)
            value = search(node.lchild, left, right);
        else if (left > mid)
            value = search(node.rchild, left, right);
        else
            value = Merger.merge(search(node.lchild, left, mid), search(node.rchild, mid + 1, right));
        return value;
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    private int update(Node node, int index, int val) {
        if (node.right == node.left && node.right == index) {
            node.val = val;
            return node.val;
        } else {
            int mid = (node.left + node.right) / 2;
            if (index <= mid)
                node.val = Merger.merge(node.rchild.val, update(node.lchild, index, val));
            else
                node.val = Merger.merge(node.lchild.val, update(node.rchild, index, val));
        }
        return node.val;
    }
}