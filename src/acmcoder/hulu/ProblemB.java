package acmcoder.hulu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Diane on 2019-09-05.
 * Goal:
 */
class HHH implements Comparable<HHH> {
    int index;
    int val;

    public HHH(int index, int val) {
        this.index = index;
        this.val = val;
    }

    @Override
    public int compareTo(HHH o) {
        if (o.val - this.val != 0)
            return this.val - o.val;
        return this.index - o.index;
    }
}

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();

        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int max = arr[i];
            for (int j = i; j < n; j++) {
                max = Math.max(arr[j],max);
                ans =(ans+max)%1000000007;
            }
        }
        System.out.println(ans);
        brute(arr);
    }

    public  static  void  brute(int[] arr)
    {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++)
//            arr[i] = scanner.nextInt();
        Arrays.sort(arr);
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i] * (i + 1);
            ans %= 1000000007;
        }
        System.out.println(ans);
    }

}
