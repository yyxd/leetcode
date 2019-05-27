package acwing.leetcode4.week2;

import java.util.Random;

/**
 * Created by HinTi on 2018/11/28.
 * Goal:
 */
public class Problem278_FirstBadVersion {
    public static int firstBadVersion(int n) {
        for(int i=1;i<=n;i++)
            if(isBadVersion(i)) {
                System.out.println(i);
                return i;
            }
        return 0;
    }

    public static int firstBadVersionBS(int n){
        int left =1,right = n,ans = 0;
        while (left<=right)
        {
            int mid = left+(right-left)/2;//(left+right)/2可能会超出int型范围
            if(isBadVersion(mid)) {
                right = mid-1;
                ans = mid;
            }
            else left = mid+1;
        }
       return ans;
    }

    public static boolean isBadVersion(int it)
    {
       int[] badV = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
       if(badV[it] == 0)// 0代表好的
           return false;
       else
           return true;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersionBS(9));
    }
}
