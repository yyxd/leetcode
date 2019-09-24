package acmcoder.netEase;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-21.
 * Goal:
 */
public class ProblemCC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int index = 1;
            int max = 0;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                if (j == 0) {
                    sum = arr[0];
                }
                if (j > 0) {
                    if (arr[j] >= sum) {
                        index++;
                        sum += arr[j];
                    } else {
                        sum = arr[j];
                        max = max > index ? max : index;
                        index = 1;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
