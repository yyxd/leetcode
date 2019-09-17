package leetcode.mock.mock1;

/**
 * Created by Diane on 2019-09-10.
 * Goal:
 */
class Node {
    int x;
    int y;
    Node parents;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Problem947_RemoveStones {

    public boolean merge(Node n1, Node n2) {
        while (n1.parents != n1) {
            n1 = n1.parents;
        }
        while (n2.parents != n2) {
            n2 = n2.parents;
        }
        if (n1 == n2) return false;
        n1.parents = n2;
        return true;
    }

    public int removeStones(int[][] stones) {
        //max 1000
        Node[] nodes = new Node[stones.length];
//        Node[] parents = new Node[stones.length];
//        for(int i=0;i<)
        for (int i = 0; i < stones.length; i++) {
            Node cur = new Node(stones[i][0], stones[i][1]);
            cur.parents = cur;
        }
        return 0;
    }

    public int removeStones2(int[][] stones) {
        //max 1000
//        for(int )
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(~2);
    }
}
