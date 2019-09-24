package acmcoder.tencent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Diane on 2019-09-20.
 * Goal:
 */
class Data {
    int count;
    int time;

    public Data(int count, int time) {
        this.count = count;
        this.time = time;
    }
}

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Data[] arr = new Data[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arr[i] = new Data(x, y);
        }
        Arrays.sort(arr, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.time - o2.time;
            }
        });
        int left = 0, right = n - 1;
        int max = 0;
        while (left <= right) {
            int sum = arr[left].time + arr[right].time;
            max = Math.max(sum, max);
            arr[left].count--;
            arr[right].count--;
            if (arr[left].count == 0)
                left++;
            if (arr[right].count == 0)
                right--;
        }
        System.out.println(max);
    }
}
