package acmcoder.tencent;

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
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int v = a[i] + b[j];
                ans ^= v;
            }
        System.out.println(ans);
    }
}
