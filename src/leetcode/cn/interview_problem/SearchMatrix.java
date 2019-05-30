package leetcode.cn.interview_problem;

/**
 * Created by Diane on 2019-05-23.
 * Goal:
 */
public class SearchMatrix {
    /**
     * 从 第一行最后一列开始
     * 与matrix[m][n]比较 如果小于的话，删除该列，n--, 如果大于的话，删除改行 m++
     **/
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length<=0) return false;
        int r = matrix.length, c = matrix[0].length;
        int i = 0,j=c-1;
        while(i<r&&j>=0){
            if(matrix[i][j] == target)
                return true;
            if(target<matrix[i][j])
               j--;
            else
                i++;

        }
        return false;
    }

    public static void main(String[] args) {
        int [][]matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix,5));
    }
}
