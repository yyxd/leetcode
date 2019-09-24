package acmcoder.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Diane on 2019-09-20.
 * Goal:
 */

class Node {
    int sum = 0;
    List<Integer> values = new ArrayList<>();
}

public class ProblemCC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int iCase = 1; iCase <= T; iCase++) {
            int n = scanner.nextInt();
            int[] x = new int[n];
            for (int i = 0; i < n; i++)
                x[i] = scanner.nextInt();
            Arrays.sort(x);
            Node A = new Node();
            Node B = new Node();
            // int[0] 值 int[1] 长度
            for (int i = n - 1; i >= 0; i--) {
                List<Integer> listA = A.values;
                List<Integer> listB = B.values;
                if (listA.size() <= listB.size()) {
                    listA.add(x[i]);
                    A.sum += x[i];
                } else {
                    listB.add(x[i]);
                    B.sum += x[i];
                }
                if (listA.size() > 0 && listB.size() > 0)
                    balance(A, B);
            }
            System.out.printf("%d %d\n", Math.min(A.sum, B.sum), Math.max(A.sum, B.sum));
        }
    }

    // a b 长度相同 sumA 小于 sum B
    public static void balance(Node A, Node B) {
        List<Integer> listA = A.values;
        List<Integer> listB = B.values;
        int vi = -1, vj = -1;
        int minDis = Math.abs(A.sum - B.sum);
        for (int i = 0; i < listA.size(); i++) {
            for (int j = 0; j < listB.size(); j++) {
                int va = listA.get(i);
                int vb = listB.get(j);
                int dis = Math.abs((A.sum + vb - va) - (B.sum + va - vb));
                if (dis < minDis) {
                    vi = i;
                    vj = j;
                }
            }
        }
        if (vi == -1)
            return;
        int va = listA.get(vi);
        int vb = listB.get(vj);
        listA.remove(vi);
        listB.remove(vj);
        A.sum = A.sum - va + vb;
        B.sum = B.sum + va - vb;
        listA.add(vb);
        listB.add(va);
    }
}
