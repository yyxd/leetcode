package acmcoder.zhaohang;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-15.
 * Goal:
 */
public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        int[] ans = new int[in.length()];
        int i = 0;
        while (i < in.length()) {
            if (in.charAt(i) != 'R') break;
            int s = i;
            while ((i + 1) < in.length() && in.charAt(i + 1) == 'R') {
                i++;
            }

            int keyR = i;
            int keyL = i + 1;
            while ((i + 1) < in.length() && in.charAt(i + 1) == 'L') {
                i++;
            }
            i++;
            ans[keyL] = (keyR - s + 1) / 2 + (i - keyR) / 2;
            ans[keyR] = (keyL - s + 1) / 2 + (i - keyL) / 2;
        }
        for (int j = 0; j < ans.length; j++)
            System.out.print(ans[j] + " ");
    }
}
