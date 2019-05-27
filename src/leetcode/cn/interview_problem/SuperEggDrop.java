package leetcode.cn.interview_problem;

/**
 * Created by Diane on 2019-05-27.
 * Goal:
 * Solution:
 * 利用dp,给定i 个鸡蛋和 j层楼，至少需要X步来发现F层是多高
 * 假设当F等于1，2，...,N最坏步骤需要多少层楼
 * 假设在第t层时，鸡蛋破碎，那么F<=t ，则是利用i-1个鸡蛋，则在0~t层楼寻找F，ans[i-1][t]
 * 如果没有破碎，那么F>=t+1,则是利用i个鸡蛋在，t+1~j层寻找F ans[i][j-t]
 * ans[i][j] = Max(ans[i-1][t],ans[i][j-t])+1
 */
public class SuperEggDrop {
    public static int superEggDrop(int K, int N) {
        if (N <= 0) return 0;
        int[][] ans = new int[K + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            ans[1][i] = i;
        }
        for(int j = 1;j<=K;j++){
            ans[j][1] = 1;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <=N; j++) {
                for (int t = 1; t < j; t++) {
                    int temp = Math.max(ans[i - 1][t], ans[i][j - t-1]) + 1;
                    if(ans[i][j] == 0||ans[i][j]>temp)
                        ans[i][j] = temp;
                }
            }
        }
        return ans[K][N];
    }

    public static void main(String[] args) {
        int k =8,n=5000;
        System.out.println(superEggDrop(k,n));
    }
}
