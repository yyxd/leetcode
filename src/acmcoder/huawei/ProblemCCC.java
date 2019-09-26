package acmcoder.huawei;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-25.
 * Goal: 线段树 失误次数 累积和
 * 线段树的融合：可能有求区间和，区间的最大值，区间的最小值
 */

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

public class ProblemCCC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int iCase = 1; iCase <= T; iCase++) {
            int n = scanner.nextInt();
            int[] train = new int[n];
            for (int i = 0; i < n; i++)
                train[i] = scanner.nextInt();
            int size = 5;
            SegmentTree segTree = new SegmentTree(0, size);
            int max = 0, cur = 0;
            int val = segTree.search(train[0], train[0]);
            segTree.update(train[0], val + 1);
            for (int i = 1; i < n; i++) {
                int left = 0;
                int midl = train[i] - 1;
                int midr = train[i] + 1;
                int right = size - 1;
                int minus = segTree.search(midr, right);
                int plus = segTree.search(left, midl);
                cur = cur - minus + plus;
                max = Math.max(cur, val);
                int curVal = segTree.search(train[i], train[i]);
                segTree.update(train[i], curVal + 1);
            }
            System.out.printf("%d %d\n", max, cur);
        }
    }
}
