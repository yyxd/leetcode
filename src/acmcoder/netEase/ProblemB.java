package acmcoder.netEase;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-21.
 * Goal:
 */
public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int iCase = 1; iCase <= T; iCase++) {
            int a, b, p, q;
            a = scanner.nextInt();
            b = scanner.nextInt();
            p = scanner.nextInt();
            q = scanner.nextInt();
            if (a + p >= b)
                System.out.println(1);
            else {
                int times = 1;
                int plus = p * q;
                while (true) {
                    times++;
                    int cur = a + plus;
                    plus *= q;
                    if (cur >= b) break;
                }
                System.out.println(times);
            }
        }
    }
}
