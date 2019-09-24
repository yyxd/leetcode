package acmcoder.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Diane on 2019-09-20.
 * Goal:
 */
public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++)
            nums[i] = scanner.nextInt();
        Arrays.sort(nums);
        int minus = 0;
        int i = 0;
        for (int j = 1; j <= k; j++) {
            while (i < nums.length && nums[i] - minus <= 0) {
                i++;
            }
            if (i == nums.length)
                System.out.println(0);
            else {
                System.out.println(nums[i] - minus);
                minus += (nums[i] - minus);
            }
        }
    }
}
