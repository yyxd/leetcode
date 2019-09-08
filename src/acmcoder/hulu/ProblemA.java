package acmcoder.hulu;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-05.
 * Goal:
 */
public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n + 1];
        int[] w = new int[n + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
            sum += w[i];
        }
        int last = yuesefu(n, m);
        int goods = 0;

        for (int i = 0; i < n; i++) {
            int man = (last+i)%n;
            goods += a[man] * w[i];
        }
        double ans = (double)goods/sum;
        System.out.printf("%.5f\n",ans);

    }

    public static int yuesefu(int n, int m) {
        if (n == 0 || m <= 0)
            return -1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
