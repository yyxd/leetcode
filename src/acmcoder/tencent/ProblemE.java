package acmcoder.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Diane on 2019-09-20.
 * Goal:
 */
public class ProblemE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = scanner.nextInt();
        // 按位算贡献，计算每一位是0 还是 1
        int ans = 0;
        for (int i = 28; i >= 0; i--) {
            int mask = (1 << (i+1)) - 1;
            for (int j = 0; j < n; j++) {
                a[j] &= mask;
                b[j] &= mask;
            }
            int v = (1 << i);
            Arrays.sort(b);
            // a[k]+b中的任意元素x 可能导致第i+1 和第i位出现这样的四种情况 01,10,11,00
            // 若要使得a[k]+b第i位为1
            int t = 0;
            for (int j = 0; j < n; j++) {
                int t1 = lower_bound(b, v - a[j]);// a[k]+b>=v： 01,10,11的情况
                int t2 = lower_bound(b, 2 * v - a[j]);// a[k]+b>=2*v： 10 11 的情况
                int t3 = lower_bound(b, 3 * v - a[j]); // a[k]+b>=3*v: 11的情况
                t += t1 - t2 + t3;// 01 或 11 的情况，使得第i位为1
            }
//            System.out.printf("i= %d,t=%d\n", i, t);
            t &= 1;//判断奇偶性，只有奇数个1异或才能使得这一位为1
            if (t == 1)
                ans += v;
        }
        System.out.println(ans);
    }

    // 返回有序数组nums中>=target的元素的个数
    public static int lower_bound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) high = mid;
            else low = mid + 1;
        }
        if (nums[low] < target) return 0;
        return nums.length - low;
    }
}
