package leetcode.tree;

/**
 * Created by HinTi on 2019/2/23.
 * Goal: 字典树 字符串的插入与查找
 * Trie树并不适合做动态集合数据的查找，虽然字符串匹配十分高效，但耗费内存较多
 * 应用场景：搜索引擎的搜索关键字提示功能
 * 如何减少内存，进行优化？
 * 将存储子节点的数据结构由数组/散列表换成有序数组，红黑树，跳表等易于查找的数据结构，但是在每次插入过程中会消耗更多的时间，增加代码实现难度
 */

class TrieTreeNode {
    char val;
    TrieTreeNode[] children;
    boolean isEndingChar = false;
    public TrieTreeNode() {
    }

    public TrieTreeNode(char c) {
        val = c;
    }
}

public class TrieTree {
    TrieTreeNode root = new TrieTreeNode('/');

    public TrieTree() {

    }

    public TrieTree(String[] strs) {
        for(String str : strs) insert(str);
    }

    public void insert(String str) {
        TrieTreeNode p = root;
        for (int i = 0; i < str.length(); i++) {
            if (p.children == null) p.children = new TrieTreeNode[26];
            int index = str.charAt(i) - 'a';
            if (p.children[index] == null)
                p.children[index] = new TrieTreeNode(str.charAt(i));
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(String str){
        TrieTreeNode p = root;
        for(int i =0;i<str.length();i++){
            if(p.children==null) return false;
            int index = str.charAt(i)-'a';
            if(p.children[index]==null) return false;
            p = p.children[index];
        }
        return p.isEndingChar;
    }


    public static void main(String[] args) {
        String[] strs = {"hi","hello","buaa","beijing","beihang","love","huangdan","huang"};
        TrieTree root = new TrieTree(strs);
        root.insert("hell");
        System.out.println(root.find("hello"));
        System.out.println(root.find("hell"));
        System.out.println(root.find("he"));
        System.out.println(root.find("buaa"));
    }
}
