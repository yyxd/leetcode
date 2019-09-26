package acmcoder.huawei;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-25.
 * Goal:
 */
public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int iCase = 1; iCase <= T; iCase++) {
            int n = scanner.nextInt();
            int[] train = new int[n];
            for (int i = 0; i < n; i++)
                train[i] = scanner.nextInt();
            int max = 0;
            int cur = 0;
            for (int i = 1; i < n; i++) {
                int minus = 0;
                int plus = 0;
                for (int j = 0; j < i; j++) {
                    if (train[j] < train[i])
                        plus++;
                    else if (train[j] > train[i])
                        minus++;
                }
                cur = cur - minus + plus;
                if (cur > max)
                    max = cur;
            }
            System.out.printf("%d %d\n", max, cur);
        }
    }
}
