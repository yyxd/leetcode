package contest.contest143;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Diane on 2019-06-30.
 * Goal:
 */
public class Problem2 {
    public static List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> ans = new LinkedList<>();
        ans.addFirst(label);
        while (label!=1){
            label = getFather(label);
            ans.addFirst(label);
        }
        return ans;
    }

    public static int getFather(int k){
        int depth =0;
        int father = k/2;
        while (k/2>0){
            k = k/2;
            depth++;
        }
        int sum = (int)(Math.pow(2,depth)-1+Math.pow(2,depth-1));
        father = sum-father;
        return father;
    }

    public static void main(String[] args) {
        List<Integer> ans = pathInZigZagTree(14);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
