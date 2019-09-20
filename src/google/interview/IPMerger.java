package google.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HinTi on 2019/9/9.
 * Goal:
 */
class TrieNode {
    boolean is_leaf = false;
    TrieNode left;
    TrieNode right;

    public TrieNode(boolean is_leaf, TrieNode left, TrieNode right) {
        this.is_leaf = is_leaf;
        this.left = left;
        this.right = right;
    }

    public TrieNode() {
    }

    public TrieNode(TrieNode left, TrieNode right) {
        this.left = left;
        this.right = right;
    }
}


public class IPMerger {
    public static void main(String[] args) {
        String[] ips = {"1101", "10xx", "1100","1001","1010"};
        IPMerger merger = new IPMerger();
        List<String> ans = merger.mergeIP(ips);
        for (String s : ans)
            System.out.println(s);
    }

    public boolean isLeaf(TrieNode root) {
        if (root == null) return false;
        if (root.is_leaf) return true;
        boolean left = isLeaf(root.left);
        boolean right = isLeaf(root.right);
        root.is_leaf = (left && right);
        return root.is_leaf;
    }

    public List<String> mergeIP(String[] ips) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < ips.length; i++)
            insert(root, ips[i]);
        isLeaf(root);
        reverseTrieTree(root, new StringBuilder());
        List<String> result = new ArrayList<>();
        for (StringBuilder sb : res) {
            for (int i = sb.length(); i < 4; i++)
                sb.append('X');
            result.add(sb.toString());
        }
        return result;
    }

    List<StringBuilder> res = new ArrayList<>();

    void reverseTrieTree(TrieNode node, StringBuilder ans) {
        if (node == null || node.is_leaf) {
            res.add(ans);
            return;
        }
        if (node.left != null) {
            StringBuilder lnext = new StringBuilder(ans);
            lnext.append('0');
            reverseTrieTree(node.left, lnext);
        }
        if (node.right != null) {
            StringBuilder rnext = new StringBuilder(ans);
            rnext.append('1');
            reverseTrieTree(node.right, rnext);
        }
    }

    void insert(TrieNode root, String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                if (cur.left == null) {
                    cur.left = new TrieNode();
                }
                cur = cur.left;
            } else if (ch == '1') {
                if (cur.right == null)
                    cur.right = new TrieNode();
                cur = cur.right;
            } else if (ch == 'X') {
                cur.is_leaf = true;
                break;
            }
        }
        cur.is_leaf = true;
    }

}