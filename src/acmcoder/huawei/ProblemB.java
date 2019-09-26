package acmcoder.huawei;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-25.
 * Goal:
 */
public class ProblemB {
    public static void main(String[] args) {
        int N, M;
        Scanner scanner = new Scanner(System.in);
        String nm = scanner.nextLine();
        String[] NM = nm.split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        int[] arr = new int[N];
        int[] sum = new int[N + 1];
        String numstring = scanner.nextLine();
        String[] nums = numstring.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
            sum[i + 1] = sum[i] + arr[i];
        }

        for (int q = 0; q < M; q++) {
            String s = scanner.nextLine();
            String[] strs = s.split(" ");
            String op = strs[0];
            int v1 = Integer.parseInt(strs[1]);
            int v2 = Integer.parseInt(strs[2]);
            if (op.equals("Q")) {
                int ans = (sum[v2] - sum[v1 - 1]) / (v2 - v1 + 1);
                System.out.println(ans);
            } else {
                for (int i = v1; i <= N; i++)
                    sum[i] += v2;
            }
        }
    }
}
