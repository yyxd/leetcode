package google.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by HinTi on 2019/9/14.
 * Goal:
 */
public class LeetCode_986 {
    // 返回A B 的交集
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> ans = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int aStart = A[i][0];
            int aEnd = A[i][1];
            int bStart = B[j][0];
            int bEnd = B[j][1];
            if (aStart <= bEnd || bStart <= aEnd) {
                int[] intersection = {Math.min(aStart, bStart), Math.max(bEnd, aEnd)};
                if (intersection[0] <= intersection[1])
                    ans.add(intersection);
            }
            if (aEnd < bEnd)
                i++;
            else
                j++;
        }
        int[][] ret = new int[ans.size()][2];
        for (int k = 0; k < ans.size(); k++) {
            ret[k] = ans.get(k);
        }
        return ret;
    }

    // 返回 A B 交集，利用扫描线的思想，start+1 end -1 当有两个区间共同进入某一段时，记录下来
    static public int[][] intervalIntersection2(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        List<int[]> nodes = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int[] s = {A[i][0], 1};
            int[] e = {A[i][1], -1};
            nodes.add(s);
            nodes.add(e);
        }
        for (int i = 0; i < B.length; i++) {
            int[] s = {B[i][0], 1};
            int[] e = {B[i][1], -1};
            nodes.add(s);
            nodes.add(e);
        }
        Collections.sort(nodes, new Comparator<int[]>() {
            @Override
            // 先进后出
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                else
                    return o1[0] - o2[0];
            }
        });
        int count = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < nodes.size(); i++) {
            int[] cur = nodes.get(i);
            if (cur[1] == 1 && count == 1) {
                // 进入区间
                start = cur[0];
            } else if (cur[1] == -1 && count == 2) {
                // 离开区间
                end = cur[0];
                int[] temp = {start, end};
                ans.add(temp);
            }
            count += cur[1];
        }
        int[][] ret = new int[ans.size()][2];
        for (int k = 0; k < ans.size(); k++) {
            ret[k] = ans.get(k);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] A = {{2, 5}};
        int[][] B = {{3, 6}};
        intervalIntersection2(A, B);
    }
}