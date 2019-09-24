package contest.contest155;

import java.util.Arrays;

/**
 * Created by Diane on 2019-09-22.
 * Goal:
 */
public class UglyNumber {
    public static int nthUglyNumber(int n, int a, int b, int c) {
        int ca = 1, cb = 1, cc = 1;
        int i = 1;
        int next = a;
        int[] nums = new int[n + 1];
        while (i <= n) {
            next = Math.min(Math.min(a * ca, b * cb), c * cc);
            if (next % a == 0)
                ca++;
            if (next % b == 0)
                cb++;
            if (next % c == 0)
                cc++;
            nums[i] = next;
            i++;
        }
        System.out.println(Arrays.toString(nums));
        return next;
    }


    public static int nthUglyNumber2(int n, int a, int b, int c) {
        int ta = Math.min(a, Math.min(b, c));
        int tb, tc;
        if (a == ta) {
            tb = Math.min(b, c);
            tc = Math.max(b, c);
        } else if (b == ta) {
            tb = Math.min(a, c);
            tc = Math.max(a, c);
        } else {
            tb = Math.min(a, b);
            tc = Math.max(a, b);
        }
        int ca = 1, cb = 1, cc = 1;
        long i = 1;
        long ans = 0;
        long v = tb * tc + ta * tc + tb * tc - ta - tb - tc + 1;
        int k1 = tb / ta;
        int k2 = tc / ta;
        int k3 = tc / tb;
        long v1 = tb * ta;
        long v2 = ta * tc;
        long v3 = tb * tc;
        long v4 = ta * tb * tc;
        while (i <= n) {
            i += v;
            ans += v4;
        }
        i-=v;
        ans-=v4;

        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(4, 2, 3, 5));
        System.out.println(nthUglyNumber(4, 2, 3, 4));
        System.out.println(nthUglyNumber(5, 2, 11, 13));
    }
}
