package acmcoder.netEase;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-21.
 * Goal:
 */
public class ProblemD {

    public static int[] aux;// 辅助空间
    public static int[] remove; // 表示该元素的移位

    public static int merge(int[] nums, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        int k = 0;
        int dis = 0;
        int count = 0;
        while (i <= mid && j <= hi) {
            if (nums[i] < nums[j])
                aux[k++] = nums[i++];
            else {
                dis = dis + (j - i + j - mid) * (mid - i + 1) / 2;
                remove[i] = remove[j]+j - i;
                aux[k++] = nums[j++];
                count = mid - i + 1;
            }
        }
        while (i <= mid) aux[k++] = nums[i++];
        while (j <= hi) aux[k++] = nums[j++];
        for (int l = 0; l < k; l++) {
            nums[lo + l] = aux[l];
        }
        return count;
    }

    public static int mergeSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            int a = mergeSort(nums, lo, mid);
            int b = mergeSort(nums, mid + 1, hi);
            int v = merge(nums, lo, mid, hi);
            int ans = a + b + v;
            return ans;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        aux = new int[n];
        remove = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int ans = mergeSort(nums, 0, n - 1);
        System.out.println(ans);
    }
}
