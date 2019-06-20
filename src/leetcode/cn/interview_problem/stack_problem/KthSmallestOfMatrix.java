package leetcode.cn.interview_problem.stack_problem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by HinTi on 2019/6/20.
 * Goal: 有序矩阵中第k小的元素
 * Solution： 1.优先队列，大顶堆。但是任意矩阵都可以，本题给的是有序矩阵，没有很好的利用到该种特性
 * Solution: 2. 利用自己写的队列完成，非常的复杂，而且是链表操作容易出错
 * Solution: 3. 二分搜索，寻找第K
 */
public class KthSmallestOfMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        if(k==1) return matrix[0][0];
        int len = matrix.length;
        if(k==(len*len)) return matrix[len-1][len-1];
        Queue<Integer> bigHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (count < k) {
                    bigHeap.offer(matrix[i][j]);
                    count++;
                } else {
                    if (bigHeap.peek() > matrix[i][j]) {
                        bigHeap.poll();
                        bigHeap.offer(matrix[i][j]);
                    }
                }
            }
        }
        return bigHeap.peek();
    }

//    public static int binarySearchKth(int[][] matrix,int k){
//
//    }

    public static int anotherKth(int[][] matrix, int k) {
        int i = 0, j = 0;
        Node head = new Node(i, j, matrix[i][j]);
        NodeList queue = new NodeList();
        queue.offer(head);
        boolean visited[][] = new boolean[matrix.length][matrix.length];
        visited[0][0] = true;
        int count = 1;
        while (count < k) {
            Node pre = queue.getFirstNode();
            Node node = pre.next;
            int nextVaule = Integer.MAX_VALUE, iNext = 0, jNext = 0;
            while (node != null) {
                boolean visitedFlag = true;// 当前节点的下一个节点是否都被访问了
                if (node.iPoint + 1 < matrix.length && !visited[node.iPoint + 1][node.jPoint]) {// 判断右节点
                    if (matrix[node.iPoint + 1][node.jPoint] <= nextVaule) {
                        iNext = node.iPoint + 1;
                        jNext = node.jPoint;
                        nextVaule = matrix[iNext][jNext];
                    }
                    visitedFlag = false;
                }
                if (node.jPoint + 1 < matrix.length && !visited[node.iPoint][node.jPoint + 1]) {// 判断下节点
                    if (matrix[node.iPoint][node.jPoint + 1] <= nextVaule) {
                        iNext = node.iPoint;
                        jNext = node.jPoint + 1;
                        nextVaule = matrix[iNext][jNext];
                    }
                    visitedFlag = false;
                }
                if (visitedFlag) {
                    // 该节点的下一个节点均被访问，需要删除该节点
                    pre.next = node.next;
                    if(queue.lastNode==node)
                        queue.lastNode =pre;
                } else {
                    pre = node;
                }
                node = pre.next;
            }
            Node nextNode = new Node(iNext, jNext, matrix[iNext][jNext]);
            queue.offer(nextNode);
            visited[iNext][jNext] = true;
            count++;
        }
        return queue.peekLast();
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,6,9,12,17,22}, {5,11,11,16,22,26}, {10,11,14,16,24,31}, {10,15,17,17,29,31}, {14,17,20,23,34,37}, {19,21,22,28,37,40}};
        System.out.println(anotherKth(matrix, 35));
    }
}

//用链表来做
class Node {
    int iPoint;
    int jPoint;
    int value;
    Node next;

    public Node(int i, int j, int value) {
        iPoint = i;
        jPoint = j;
        this.value = value;
        this.next = null;
    }

    public Node() {

    }
    @Override
    public String toString() {
        return "value = "+value;
    }
}

class NodeList {
    Node NodeHead;
    Node lastNode;

    public NodeList() {
        NodeHead = new Node();
        lastNode = NodeHead;
    }

    public Node getFirstNode() {
        return NodeHead;
    }

    public int peekLast() {
        return lastNode.value;
    }

    public void offer(Node node) {
        lastNode.next = node;
        lastNode = node;
    }


}