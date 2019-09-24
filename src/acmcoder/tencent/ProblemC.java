package acmcoder.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Diane on 2019-09-20.
 * Goal:
 */

public class ProblemC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int iCase = 1; iCase <= T; iCase++) {
            int n = in.nextInt();
            int[] x = new int[n];
            for (int i = 0; i < n; i++)
                x[i] = in.nextInt();
            Arrays.sort(x);
            int[] sumA = new int[2];
            int[] sumB = new int[2];
            // int[0] 值 int[1] 长度
            for (int i = n - 1; i >= 0; i--) {
                if (sumA[1] == sumB[1]) {
                    if (sumA[0] <= sumB[0]) {
                        sumA[0] = sumA[0] + x[i];
                        sumA[1]++;
                    } else {
                        sumB[0] = sumB[0] + x[i];
                        sumB[1]++;
                    }
                } else {
                    if (sumA[1] < sumB[1]) {
                        sumA[0] = sumA[0] + x[i];
                        sumA[1]++;
                    } else {
                        sumB[0] = sumB[0] + x[i];
                        sumB[1]++;
                    }
                }
            }
            System.out.printf("%d %d\n", Math.min(sumA[0], sumB[0]), Math.max(sumA[0], sumB[0]));
        }
    }
}
