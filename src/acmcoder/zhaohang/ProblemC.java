package acmcoder.zhaohang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Diane on 2019-09-15.
 * Goal:
 */
public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        int small = 0;
        int v = 0;
        for (int i = 0; i < in.length(); i++) {
            char ch = in.charAt(i);
            if (ch == '?') {
                ch = '0';
                v++;
            }
            small = small * 10 + (ch - '0');
            small %= 13;
        }
        int ans = 0;
        if (small % 13 == 5) {
            ans++;
        }
        int mod = 1000000007;
        long cal = 1;
        long temp = (long) Math.pow(10, v);
        cal = (cal * (temp / 13) % mod) % mod;
        ans = (int) cal + ans;
        System.out.println(ans);
    }
}
