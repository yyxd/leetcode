package leetcode.array;

/**
 * Created by hh23485 on 2017/11/8.
 */
public class Problem566 {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int [][]ans = new int[r][c];
        int m=0,n=0;
        if(r*c!=nums.length*nums[0].length)
            return nums;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                ans[m][n]=nums[i][j];
                n++;
                if(n==c){
                    m++;
                    n=0;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int nums[][]={{1,2},{3,4}};
        int r=2,c=4;
        int [][]ans = matrixReshape(nums,r,c);
        for (int i=0;i<ans.length;i++) {
            for (int j = 0; j < ans[0].length; j++)
                System.out.print(ans[i][j]+"    ");
            System.out.println("\n=========================");
        }
    }
}
