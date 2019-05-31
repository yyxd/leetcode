package leetcode.cn.interview_problem.string_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diane on 2019-05-30.
 * Goal: 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 建议用Trie树
 */

class Trie {
    private Trie[] children = new Trie[26];
    private boolean status = false;

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie curNode = this;
        Trie nextNode;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curNode.children[index] == null)
                curNode.children[index] = new Trie();
            nextNode = curNode.children[index];
            curNode = nextNode;
        }
        curNode.status = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie curNode = this;
        Trie nextNode;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            nextNode = curNode.children[index];
            if (nextNode == null)
                return false;
            curNode = nextNode;
        }
        return curNode.status;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie curNode = this;
        Trie nextNode;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            nextNode = curNode.children[index];
            if (nextNode == null)
                return false;
            curNode = nextNode;
        }
        return true;
    }
}

public class SearchWordII {
    List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length <= 0) return ans;
        Trie root = createTrieTree(words);
        StringBuilder sb ;
        boolean[][] visited;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                visited = new boolean[board.length][board[0].length];
                sb = new StringBuilder();
                recurse(board, i, j, root, sb, visited);
            }
        return ans;
    }

    public void recurse(char[][] board, int i, int j, Trie root, StringBuilder prefix, boolean[][] visited) {
        if(i<0||i>=board.length||j<0||j>=board[0].length) return;
        if (visited[i][j])
            return;
        visited[i][j] = true;
        prefix.append(board[i][j]);
        if (root.search(prefix.toString())) {
            if (!ans.contains(prefix.toString()))
                ans.add(prefix.toString());
            prefix.deleteCharAt(prefix.length()-1);
            return;
        }
        if (!root.startsWith(prefix.toString())) {
            prefix.deleteCharAt(prefix.length()-1);
            visited[i][j] = false;
            return;
        }
        recurse(board, i + 1, j, root, prefix, visited);
//        visited[i+1][j] = false;
        recurse(board, i - 1, j, root, prefix, visited);
//        visited[i-1][j] = false;
        recurse(board, i, j + 1, root, prefix, visited);
//        visited[i][j+1] = false;
        recurse(board, i, j - 1, root, prefix, visited);
//        visited[i][j-1] = false;
        visited[i][j] = false;
        prefix.deleteCharAt(prefix.length()-1);

//        if (i + 1 < board.length) {
//            prefix.append(board[i + 1][j]);
//            recurse(board, i + 1, j, root, prefix, visited);
//            prefix.deleteCharAt(prefix.length() - 1);
//        }
//        if (i - 1 >= 0) {
//            prefix.append(board[i - 1][j]);
//            recurse(board, i - 1, j, root, prefix, visited);
//            prefix.deleteCharAt(prefix.length() - 1);
//        }
//        if (j + 1 < board[0].length) {
//            prefix.append(board[i][j + 1]);
//            recurse(board, i, j + 1, root, prefix, visited);
//            prefix.deleteCharAt(prefix.length() - 1);
//        }
//        if (j - 1 >= 0) {
//            prefix.append(board[i][j - 1]);
//            recurse(board, i, j - 1, root, prefix, visited);
//            prefix.deleteCharAt(prefix.length() - 1);
//        }
//        prefix.deleteCharAt(prefix.length()-1);
    }

    public Trie createTrieTree(String[] words) {
        Trie root = new Trie();
        for (String str : words) {
            root.insert(str);
        }
        return root;
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board2 = {{'a','b'},{'c','d'}};
        String[] words2 = {"cdba"};
        SearchWordII sw2 = new SearchWordII();
        List<String> ans = sw2.findWords(board2, words2);
        for (String str : ans) {
            System.out.println(str);
        }
    }
}
