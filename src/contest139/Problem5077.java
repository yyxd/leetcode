package contest139;

import java.util.HashMap;

/**
 * Created by Diane on 2019-06-02.
 * Goal: 二维矩阵按照列翻转得到相同的最大行数
 */
public class Problem5077 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ans = 1;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int p = 1;
            for (int j = i + 1; j < n; j++) {
                boolean re = false;
                boolean succ = true;
                if (matrix[i][0] != matrix[j][0]) {
                    re = true;
                }
                for (int k = 0; k < m; k++) {
                    if (re) {
                        if (matrix[i][k] == matrix[j][k]) {
                            succ = false;
                            break;
                        }
                    } else {
                        if (matrix[i][k] != matrix[j][k]) {
                            succ = false;
                            break;
                        }
                    }
                }
                if (succ) {
                    p++;
                }
            }
            ans = Math.max(ans, p);
        }

        return ans;
    }

    public static int anotherMaxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            StringBuilder reverseSb = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
                reverseSb.append(1 - matrix[i][j]);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            map.put(reverseSb.toString(), map.getOrDefault(reverseSb.toString(), 0) + 1);
        }
        int ans = 1;
        for (String str : map.keySet()) {
            ans = Math.max(ans, map.get(str));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(anotherMaxEqualRowsAfterFlips(matrix));

    }
}
