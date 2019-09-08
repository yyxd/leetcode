package contest.contest139;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Diane on 2019-06-02.
 * Goal: 元素为目标值的矩阵数量
 */
public class Problem5075 {
    public  int numSubmatrixSumTarget(int[][] matrix, int target) {
        if(matrix.length<=0) return 0;
        int[][] sum = new int[matrix.length][matrix[0].length];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < sum.length; i++) {
            sum[i][0] = matrix[i][0]+sum[i-1][0];
        }
        for (int j = 1; j < sum[0].length; j++) {
            sum[0][j] = matrix[0][j]+sum[0][j-1];
        }
        for(int i=1;i<sum.length;i++){
            for(int j=1;j<sum[i].length;j++){
                sum[i][j] = matrix[i][j]+sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
            }
        }
        int ans = 0;
        for(int si=0;si<sum.length;si++){
            for(int sj=0;sj<sum[si].length;sj++)
            for (int ei=si;ei<sum.length;ei++){
                for(int ej = sj;ej<sum[ei].length;ej++)
                {
                    if(target ==getAns(si,sj,ei,ej,sum))
                       ans++;
                }
            }
        }
        return ans;
    }

    /**
     * hash map 空间换时间 O(n^3)
     * @param a
     * @param target
     * @return
     */
    public int anotherNumSubmatrixSumTarget(int[][] a,int target){
        int n = a.length, m = a[0].length;
        int[][] cum = new int[n+1][m+1];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                cum[i+1][j+1] = cum[i+1][j] + cum[i][j+1] - cum[i][j] + a[i][j];
            }
        }

        int ans = 0;
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                Map<Integer, Integer> map = new HashMap<>();
                for(int k = 0;k <= m;k++){
                    int v = cum[j+1][k] - cum[i][k];
                    if(map.containsKey(v - target)){
                        ans += map.get(v-target);
                    }
                    if(map.containsKey(v)){
                        map.put(v, map.get(v)+1);
                    }else{
                        map.put(v, 1);
                    }
                }
            }
        }
        return ans;
    }
    public  int getAns(int starti,int startj,int endi,int endj,int[][] sum){
        if(starti-1<0 && startj-1<0) return sum[endi][endj];
        if(starti-1<0) return sum[endi][endj]-sum[endi][startj-1];
        if(startj-1<0)
            return sum[endi][endj]-sum[starti-1][endj];
        return sum[endi][endj]+sum[starti-1][startj-1]-sum[starti-1][endj]-sum[endi][startj-1];
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,-1},{-1,1}};
//        System.out.println(numSubmatrixSumTarget(matrix,0));
    }
}
