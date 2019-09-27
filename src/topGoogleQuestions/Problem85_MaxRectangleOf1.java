package topGoogleQuestions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by HinTi on 2019/9/26.
 * Goal: 最大由1组成的矩形？？？好多种条件，以后再做吧。
 */
public class Problem85_MaxRectangleOf1 {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        int[][][] nodes = new int[rows][cols][4];
        // 0 left 1 up 2 max.left 3 max.up
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = matrix[i][j];
                int[] cur = nodes[i][j];
                if (ch == '0') continue;
                int left = i - 1 >= 0 ? nodes[i - 1][j][0] : 0;
                int up = j - 1 >= 0 ? nodes[i][j - 1][1] : 0;
                int preLeft = i - 1 >= 0 && j - 1 >= 0 ? nodes[i - 1][j - 1][2] : left;
                int preUp = i - 1 >= 0 && j - 1 >= 0 ? nodes[i - 1][j - 1][3] : up;
                cur[0] = left + 1;
                cur[1] = up + 1;
                cur[2] = Math.min(left, preLeft) + 1;
                cur[3] = Math.min(up, preUp) + 1;
                ans = Math.max(ans, Math.max(cur[2] * cur[3], Math.max(cur[0], cur[1])));
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(Arrays.toString(nodes[i][j]) +"\t");
            }
            System.out.println();
        }
        return ans;
    }
}