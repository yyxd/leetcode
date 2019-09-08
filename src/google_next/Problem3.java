package google_next;

/**
 * Created by Diane on 2019-07-07.
 * Goal:
 */
public class Problem3 {
    public static void main(String[] args) {
        System.out.println(countWays(1));
        System.out.println(countWays(2));
        System.out.println(countWays(3));
        System.out.println(countWays(4));
    }

    public static int countWays(int n) {
        if(n<=2) return n;
        if(n==3) return 4;
        int[] ans = new int[n+1];
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 4;
        for(int i =4;i<=n;i++){
            ans[i] = ((ans[i-3]+ans[i-2])%1000000007+ans[i-1])%1000000007;
        }
        return ans[n];
    }
}
