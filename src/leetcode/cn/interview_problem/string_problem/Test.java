package leetcode.cn.interview_problem.string_problem;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Created by HinTi on 2019/5/30.
 * Goal:
 */
class Node{
    Node []children=new Node[26];
    int value;
}
public class Test {


    public static void main(String[] args) {
        Node node = new Node();
        System.out.println(node.children[1]==null);
    }
}
