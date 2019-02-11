package leetcode.dp;

import java.util.List;

/**
 * Created by Diane on 2019/2/11.
 * Goal: 给一个由整数组成的三角形，自上而下寻找最短的一条路径
 * Solution: 设置一个数组A[0...n-1][0...n-1]，A[i][j]代表到达第i行第j列结点的最短路径
 * DP转移方程式为：A[i][j]=min(A[i-1][j-1],A[i-1][j])+triangle[i][j]
 * 其中二维数组可以简化为一维数组，因为我们只需要上一行结点的信息
 * 然后遍历到达最后一行的节点的路径，找到最短路径的值
 */
public class Problem120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int t = triangle.size();
        if(t<=0) return 0;
        int end = triangle.get(t-1).size();
        if(triangle.get(0).size()<=0) return 0;
        int[] res = new int[end];
        for(int i=0;i<end;i++) res[i] = Integer.MAX_VALUE;
        res[0] = triangle.get(0).get(0);
        for(int i=1;i<t;i++){
            for(int k=triangle.get(i).size()-1;k>=0;k--){
                if(k>=1)
                    res[k] = Math.min(res[k],res[k-1])+triangle.get(i).get(k);
                else
                    res[k] = res[k]+triangle.get(i).get(k);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<end;i++)
            ans = Math.min(ans,res[i]);
        return ans;
    }

    public static void main(String[] args) {

    }
}
