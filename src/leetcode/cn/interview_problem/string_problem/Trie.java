package leetcode.cn.interview_problem.string_problem;

/**
 * Created by HinTi on 2019/5/30.
 * Goal: 创建trie树
 */

public class Trie {
    private Trie []children = new Trie[26];
    private boolean status = false;
    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curNode = this;
        Trie nextNode;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(curNode.children[index]==null)
                curNode.children[index] = new Trie();
            nextNode = curNode.children[index];
            curNode = nextNode;
        }
        curNode.status = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curNode = this;
        Trie nextNode;
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            nextNode = curNode.children[index];
            if(nextNode==null)
                return false;
            curNode = nextNode;
        }
        return curNode.status;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curNode = this;
        Trie nextNode;
        for(int i=0;i<prefix.length();i++) {
            int index = prefix.charAt(i) - 'a';
            nextNode = curNode.children[index];
            if(nextNode==null)
                return false;
            curNode = nextNode;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("apple"));
    }
}
