package contest139;

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
                    if (re){
                        if (matrix[i][k] == matrix[j][k]){
                            succ = false;
                            break;
                        }
                    } else {
                        if (matrix[i][k] != matrix[j][k]){
                            succ = false;
                            break;
                        }
                    }
                }
                if (succ){
                    p ++;
                }
            }
            ans = Math.max(ans, p);
        }

        return ans;
    }
}
