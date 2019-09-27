package topGoogleQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HinTi on 2019/9/26.
 * Goal:
 */
public class Problem1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        // generate prefix sum
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                matrix[i][j] = matrix[i][j - 1] + matrix[i][j];
            }
        }
        int res = 0;
        for (int j = 0; j < col; j++) {
            for (int k = -1; k < j; k++) {
                Map<Integer, Integer> counter = new HashMap<>();
                counter.put(0, 1);
                int cur = 0;
                for (int i = 0; i < row; i++) {
                    cur = matrix[i][j] - (k >= 0 ? matrix[i][k] : 0) + cur;
                    res += counter.getOrDefault(cur - target, 0);
                    counter.put(cur, counter.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}