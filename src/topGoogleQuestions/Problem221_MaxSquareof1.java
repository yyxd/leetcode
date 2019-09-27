package topGoogleQuestions;

/**
 * Created by HinTi on 2019/9/26.
 * Goal:
 */
class SquareNode {
    int up;
    int left;
    int max;
}

public class Problem221_MaxSquareof1 {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        SquareNode[][] nodes = new SquareNode[rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = matrix[i][j];
                nodes[i][j] = new SquareNode();
                SquareNode cur = nodes[i][j];
                if (ch == '0') continue;
                int left = i - 1 >= 0 ? nodes[i - 1][j].left : 0;
                int up = j - 1 >= 0 ? nodes[i][j - 1].up : 0;
                int pre = i - 1 >= 0 && j - 1 >= 0 ? nodes[i - 1][j - 1].max : 0;
                cur.left = left + 1;
                cur.up = up + 1;
                cur.max = Math.min(left, Math.min(up, pre)) + 1;
                ans = Math.max(ans, cur.max);
            }
        }
        return ans*ans;
    }
}