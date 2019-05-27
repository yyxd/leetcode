package acwing.leetcode4.week1;

/**
 * Created by Diane on 2018/11/14.
 */
public class Problem148 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0;i<len-1;i++){
            for(int j=0;j<len-1-i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][len-1-i];
                matrix[len-1-j][len-1-i] = temp;
            }
        }
        for(int i=0;i<len/2;i++)
        {
            for(int j=0;j<len;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-1-i][j];
                matrix[len-1-i][j] = temp;
            }
        }
    }
}
