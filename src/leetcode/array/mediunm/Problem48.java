package leetcode.array.mediunm;

/**
 * Created by HinTi on 2018/8/24.
 */
public class Problem48 {
    //解法一：计算每个元素旋转后的新位置，4个一循环
    public static void rotate(int [][] matrix)
    {
        int n = matrix.length;
        for (int i = 0;i<n/2;i++){
            for (int j = i;j<n-1-i;j++){
                int tmp = matrix[i][j];
                matrix [i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }

    //解法二: 以对角线为轴翻转，再以X轴中线上下翻转

    public static void rotate2(int [][]matrix)
    {
        int n = matrix.length;
        for(int i =0;i<n-1;i++)
            for (int j =0;j<n-i;j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = tmp;
            }
        for (int i = 0;i<n/2;i++){
            for (int j =0;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = tmp;
            }
        }
    }
}
