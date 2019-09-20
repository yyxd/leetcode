package google.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HinTi on 2019/9/9.
 * Goal: 求数组中两个数的最大异或和
 * Solution: 1. 建立一颗Trie树,然后对每个数都利用trie树匹配一遍，获取到最大值
 * 2. 利用set 贪心策略，异或拥有性质 a^b = c, 那么c^a = b,每次选取最大的prefix
 * 3. 看是否能够利用递归直接在树中找到最大值
 */

public class Problem421 {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = buildTrieTree(nums);
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int xorValue = 0;
            TrieNode cur = root;
            for (int j = 31; j >= 0; j--) {
                boolean flag = getBit(nums[i], j);
                // 当前为0，看当前节点是否有为1的子节点
                if (!flag) {
                    if (cur.right != null) {
                        xorValue += (1 << j);
                        cur = cur.right;
                    } else
                        cur = cur.left;
                } else {// 当前为1 ，尽可能匹配为0的子节点
                    if (cur.left != null) {
                        xorValue += (1 << j);
                        cur = cur.left;
                    } else
                        cur = cur.right;
                }
            }
            maxNum = Math.max(xorValue, maxNum);
        }
        return maxNum;
    }

    public int findMaximumXORWithSet(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> prefixes = new HashSet<>();
            int tmp = max + (1 << i);
            for (int num : nums) {
                prefixes.add(num & mask);
            }
            for (int prefix : prefixes) {
                if (prefixes.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
            mask = max;
        }
        return max;
    }

    public int findMaximumXORWithRecursive(int[] nums) {
        TrieNode root = buildTrieTree(nums);
        int level = 31, ans = 0;
        TrieNode cur = root;
        while (cur != null && (cur.left == null || cur.right == null)) {
            cur = cur.left == null ? cur.right : cur.left;
            level--;
        }
        if (cur != null) {
            ans = (1 << level);
            ans += dfs(cur.left, cur.right, level);
        }
        return ans;
    }

    public int dfs(TrieNode left, TrieNode right, int level) {
        int max = 0;
        level--;
        TrieNode ll = left.left, lr = left.right, rl = right.left, rr = right.right;
        // 如果当前层存在异或为1的子树
        if (ll != null && rr != null || lr != null && rl != null) {
            max += (1 << level);
            int t1 = 0, t2 = 0;
            if (ll != null && rr != null)
                t1 = dfs(ll, rr, level);
            if (lr != null && rl != null)
                t2 = dfs(lr, rl, level);
            max = max + Math.max(t1, t2);
        } else {// 当前层不存在异或为1的子树
            int t1 = 0, t2 = 0;
            if (ll != null && rl != null)
                t1 = dfs(ll, rl, level);
            if (lr != null && rr != null)
                t2 = dfs(lr, rr, level);
            max = Math.max(t1, t2);
        }
        return max;
    }

    public TrieNode buildTrieTree(int[] nums) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < nums.length; i++) {
            insert(root, nums[i]);
        }
        return root;
    }

    public void insert(TrieNode root, int num) {
        for (int i = 31; i >= 0; i--) {
            if (!getBit(num, i)) {
                if (root.left == null)
                    root.left = new TrieNode();
                root = root.left;
            } else {
                if (root.right == null)
                    root.right = new TrieNode();
                root = root.right;
            }
        }
    }

    private boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }


    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        Problem421 problem421 = new Problem421();
        System.out.println(problem421.findMaximumXORWithSet(nums));
    }
}