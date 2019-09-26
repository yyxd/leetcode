package acmcoder.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Diane on 2019-09-25.
 * Goal:
 */
public class ProblemCC {
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
            ArrayList<Integer> res = new ArrayList<>();
            PriorityQueue<Integer> queue  = new PriorityQueue<>();
            res.add(train[0]);
            queue.add(train[0]);
            for (int i = 1; i < n; i++) {
                int plus = getCountLowerThanK(res, train[i]);
                int minus = getCountHigherThanK(res, train[i]);
//                System.out.println("plus: " + plus);
//                System.out.println("minus: " + minus);
                cur = cur + plus - minus;
                max = Math.max(cur, max);
                res.add(train[i]);
                Collections.sort(res);
            }
            System.out.printf("%d %d\n", max, cur);
        }
    }

    // 找到所有失误次数少于当前的，找出>=当前的值的下标
    public static int getCountLowerThanK(ArrayList<Integer> list, int k) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= k) right = mid;
            else
                left = mid + 1;
        }
        if (list.get(left) < k) return list.size();
        return left;
    }

    // 找到所有失误次数大于当前的，找出<=当前的值的下标
    public static int getCountHigherThanK(ArrayList<Integer> list, int k) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (list.get(mid) <= k)
                left = mid;
            else
                right = mid - 1;
        }
        if (list.get(left) > k) return list.size();// 是小于等于当前值的第一个下标，如果left> k
        return list.size() - left - 1;
    }
}
