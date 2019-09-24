package acmcoder.netEase;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-21.
 * Goal:
 */
public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int iCase = 1; iCase <= T; iCase++) {
            int num = scanner.nextInt();
            if (num < 10) System.out.println(num);
            else
                System.out.println(getSmallest(num));

        }
    }

    public static String getSmallest(int num) {
        int k = num / 9;
        int s = num % 9;
        StringBuilder ans = new StringBuilder();
        if (s != 0)
            ans.append(s);
        for (int i = 0; i < k; i++)
            ans.append(9);
        return ans.toString();
    }
}
