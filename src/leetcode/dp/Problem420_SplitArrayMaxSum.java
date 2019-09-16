package leetcode.dp;

/**
 * Created by Diane on 2019-09-08.
 * Goal:
 */
public class Problem420_SplitArrayMaxSum {
    public int splitArrayWithDP(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) { // 一共分成m份
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }


    public int splitArrayWithBinSearch(int[] nums, int m) {
        long l = 0;// nums 的最小值
        long r = 0;// nums 之和 ,有可能会超过int
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            r += nums[i];
            if (l < nums[i]) {
                l = nums[i];
            }
        }
        long ans = r;
        while (l <= r) {
            long mid = (l + r) >> 1;
            int cnt = getCnt(nums,n,mid);
            if (cnt <= m) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ans;
    }
    // 贪心找到使得子数组和不超mid，至少需要将子数组分割成多少份
    public int getCnt(int[] nums,int n, long mid){
        long sum = 0;
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if (sum + nums[i] > mid) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt;
    }

}
